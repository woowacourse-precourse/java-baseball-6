package baseball;

import java.util.List;

public class Game {
    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        List<Integer> computerNum = computer.getComputerNum();
    }
}
