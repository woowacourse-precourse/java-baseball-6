package baseball.service;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        Computer computer = new Computer();

    }

    public boolean isReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String cmd = Console.readLine();
        if (cmd.equals("1")) {
            return true;
        }

        if (cmd.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
