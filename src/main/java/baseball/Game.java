package baseball;

import java.io.Console;
import java.util.List;

public class Game {

    private Computer computer;

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        //컴퓨터 생성
        computer = new Computer();

        while (playGame()) {

        }


    }
    private boolean playGame(){
        boolean retryCheck; // 재시도 여부 체크

        //컴퓨터의 랜덤 값 생성
        List<Integer> answer = computer.createAnswer();

        while (true){
            System.out.println("숫자를 입력해주세요 : ");
            // 유저 입력 받기

            // 딜러의 입력값 컴퓨터 입력값 비교

            // 딜러의 결과값 출력

            // 성공 여부 체크 후 return
        }
    }
}
