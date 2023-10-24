package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;


public class Application {
    public static String START_MSG = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //step0. 게임 시작
        System.out.println(START_MSG);
        while(true) {
            //step1. 랜덤 숫자 생성
            List<Integer> computer = getRandomNumbers();
        }
    }


    /**
     * 랜덤 숫자를 생성해 리스트 형태로 반환하는 함수
     */
    public static List<Integer> getRandomNumbers() {
        List<Integer> randList = new ArrayList<>();
        while (randList.size() < 3) { //3자리의 자연수
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1부터 9까지의 숫자로 구성
            if (!randList.contains(randomNumber)) {
                randList.add(randomNumber); //중복 불가
            }
        }
        return randList;
    }
}
