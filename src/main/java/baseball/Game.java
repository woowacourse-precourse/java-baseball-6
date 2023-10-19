package baseball;

import java.util.ArrayList;

public class Game {
    private Computer computer = new Computer();
    private User user = new User();
    Game(){
    }

    public void startGame(){ //숫자 야구 게임을 시작하는 메소드
        this.computer.setNumbers(); //컴퓨터의 숫자 정하기
        while(true){ //종료 조건 : 3스트라이크
            System.out.print("숫자를 입력해주세요: ");
            this.user.setGuessNumber(); //플레이어의 숫자 입력 받기
        }
    }

    /*
    private int[] checkNumber(){ //컴퓨터의 숫자와 플레이어가 입력한 숫자를 비교하여 스트라이크와 볼의 개수를 리턴하는 메소드

    }
    */
}
