package baseball.common.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

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
