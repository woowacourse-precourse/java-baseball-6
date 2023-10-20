package baseball;

import java.util.List;

public class BaseballGame {
    public void startGame(){
        //(1) 컴퓨터 : 1에서 9까지 서로 다른 임의의 수 3개 생성
        Computer computer = new Computer();
        List<Integer> computerNumbs = computer.getNumbers();
        System.out.println("컴퓨터 생성 수 : " + computerNumbs);
    }
}
