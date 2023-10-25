package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Session {
    private static final String victoryMessage = String.format(
            "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", Constants.NUMBER_GAME_LENGTH);
    private static boolean isGameRunning = true;

    // 프로그램 시작, 응답받기
    public static void startGame() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();

            ValidationAnswer.isValid(answer);
            ScoreKeeper.printScore(answer);

            if (ScoreKeeper.isThreeStrikes()) {
                askRestartOrEnd();
            }
        } while (isGameRunning);
    }

    // 프로그램 종료여부
    private static void askRestartOrEnd() {
        System.out.println(victoryMessage);
        String restart = Console.readLine();

        ValidationRestart.isValid(restart);

        int isRestart = Integer.parseInt(restart);

        switch (isRestart) {
            case 1:
                restartGame();
                break;
            case 2:
                System.out.println("프로그램을 종료합니다.");
                isGameRunning = false;
                break;
            default:
                break;
        }
    }

    // 프로그램 재시작
    private static void restartGame() {
        Defender.reroll();
    }
}
