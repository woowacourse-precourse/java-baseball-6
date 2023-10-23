package baseball.controller;

import baseball.user.Computer;

public class GameMaster {

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        computer.generateBaseballNumbers();
    }
}
