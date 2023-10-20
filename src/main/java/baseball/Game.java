package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final TargetNumber targetNumber = TargetNumber.generate(0, 0, 0);

    private Game() {}

    public static Game generate() { return new Game(); }

    public void start() {
        do {

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
        } while (Integer.parseInt(Console.readLine()) == 1);
    }
}
