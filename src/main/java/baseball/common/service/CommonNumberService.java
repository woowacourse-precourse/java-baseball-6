package baseball.common.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CommonNumberService {

    //컴퓨터가 생성한 랜덤 정답 저장
    private ArrayList<Integer> computer;
    //컴퓨터 응답 캐시 저장
    private HashMap<String,String> cache;

    //정답은 3자리
    public static final int NUMBER_LENGTH = 3;

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


    public ArrayList<Integer> getComputer(){
        return computer;
    }

    //캐시를 우선적으로 확인하기
    private String findCorrectInCache(String input){
        return cache.get(input);
    }

    //응답을 캐시에 저장하기
    private void putInputInCache(String input, String answer){
        if(!cache.containsKey(input)) cache.put(input,answer);
    }
}
