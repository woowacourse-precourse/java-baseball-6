package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public void input() {
        System.out.println("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        Number num = new Number(str);
        Computer computer = new Computer();
        computer.checkScore(num.list);
    }

    public void restartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String key = Console.readLine();
        if (key.equals("1")) {
            Game.runGame();
        } else if (key.equals("2")) {
            return;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }
}