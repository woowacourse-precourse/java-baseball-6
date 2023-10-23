package baseball.common.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CommonNumberService {

    //컴퓨터가 생성한 랜덤 정답 저장
    private List<Integer> computer;
    //컴퓨터 응답 캐시 저장
    private HashMap<String,String> cache;

    //정답은 3자리
    public static final int NUMBER_LENGTH = 3;

    //도전 카운트
    private int count = 1;

    //생성자
    public CommonNumberService(){
        computer = new ArrayList<>();
        cache = new HashMap<>();
    }

    //임의의 3자리 숫자 생성 로직
    public void createRandomNumber(){

        //정답 초기화
        computer.clear();
        //캐시 최기화
        cache.clear();

        while(computer.size()<NUMBER_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

    }

    //사용자 입력 유효성 검사
    private boolean isValid(String number){

        //캐시에 존재한다면 유효하다
        if(cache.containsKey(number)) return true;

        //사용자 입력에는 0이 포함되어서는 안된다
        if(number.contains("0")) throw new IllegalArgumentException("정답에는 0이 포함될 수 없습니다");

        //사용자 입력은 3자리여야 한다
        if(number.length()!=NUMBER_LENGTH) throw new IllegalArgumentException("정답은 3자리 숫자입니다");

        //사용자 입력은 숫자이어야 한다
        try{
            int numberToInt = Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("정답은 숫자로 입력해야 합니다");
        }

        //사용자가 중복된 숫자를 입력하면 안된다
        HashSet<Character> characterHashSet = new HashSet<>();
        for(int index=0;index<NUMBER_LENGTH;index++){
            if(characterHashSet.contains(number.charAt(index))){
                throw new IllegalArgumentException("정답은 서로 다른 숫자입니다");
            }
            characterHashSet.add(number.charAt(index));
        }

        return true;

    }

    //사용자 입력과 정답 비교
    public String isCorrect(String input){

        int strike = 0;
        int ball = 0;

        //물어본 적이 있는 질문이라면 캐시에서 반환
        String cacheValue = findCorrectInCache(input);
        if(cacheValue!=null) return findCorrectInCache(input);

        //유효한 입력에 대해서만 결과 반환
        if(isValid(input)){

            for(int index=0;index<NUMBER_LENGTH;index++){

                int nowNum = input.charAt(index)-48;
                if(nowNum==computer.get(index)) strike++;
                else if(computer.contains(nowNum)) ball++;
            }
            if(strike==0&&ball==0) return "낫싱";
            StringBuilder sb = new StringBuilder();
            if(ball>0) sb.append(ball + "볼 ");
            if(strike>0) sb.append(strike + "스트라이크");


            String answer = sb.toString();

            //캐시에 저장
            putInputInCache(input,answer);

            //정답 맞추면 count 초기화
            if(strike==3) count=1;
            return answer;
        }

        return null;
    }


    //캐시를 우선적으로 확인하기
    private String findCorrectInCache(String input){
        return cache.get(input);
    }

    //응답을 캐시에 저장하기
    private void putInputInCache(String input, String answer){
        if(!cache.containsKey(input)) cache.put(input,answer);
    }

    //캐시 getter
    public HashMap<String,String> getCache(){
        return cache;
    }

    //정답 getter
    public List<Integer> getComputer(){
        return computer;
    }

    //도전 숫자 캡슐화
    public int getCount(){
        return count;
    }

    //카운트 추가
    public void plusCount(){
        count++;
    }

    //카운트 리셋
    public void resetCount(){
        count = 1;
    }

    public int getNumberLength(){return NUMBER_LENGTH;}

}
