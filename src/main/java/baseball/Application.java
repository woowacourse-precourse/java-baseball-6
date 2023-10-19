package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> computerNumber;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

        GameStart();
    }

    public static void GameStart(){
        //컴퓨터가 서로 다른 3개의 숫자 생성

        computerNumber = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumber.add(randomNumber);
        }


    }
}
