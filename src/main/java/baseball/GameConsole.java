package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameConsole {

    // 외부에서 메서드를 바로 사용하는 클래스이므로 외부에서 사용할 메서드를 스태틱으로 선언한다.
    public static void playGame() {
        boolean playAgain;

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 게임이 실행되는 동안 생성된 첫 컴퓨터넘버는 고정된다.
            ComputerNumber computerNumber = new ComputerNumber();
            // 3개를 다 맞히면 matchRound 루프에서 빠져 나온다.
            matchRound(computerNumber);
            // 2를 선택하면 playGame 루프에서 빠져 나온다.
            playAgain = isPlayAgain();
        } while (playAgain);

        Console.close();
        System.out.println("숫자 야구 게임을 종료합니다.");
    }

    private static void matchRound(ComputerNumber computerNumber) {
        boolean rematch = true;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            PlayerNumber playerNumber = new PlayerNumber();
            Counter counter = new Counter(computerNumber, playerNumber);

            // 3개를 다 맞히면 재경기를 하지 않는다.
            rematch = isRematch(counter, rematch);
        } while (rematch);
    }

    private static boolean isRematch(Counter counter, boolean rematch) {
        int balls = counter.countBalls();
        int strikes = counter.countStrikes();

        Printer.printResult(balls, strikes);

        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            rematch = false;
        }

        return rematch;
    }

    private static boolean isPlayAgain() {
        // 1, 2 이외 다른 숫자를 입력하거나 숫자를 입력하지 않을 경우 IllegalArgumentException 발생
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Parser.parseNumber();
        return switch (choice) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력하세요.");
        };
    }
}
