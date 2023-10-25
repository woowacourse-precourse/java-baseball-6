package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameProcess {
    public static void gameStart() {
        List<Integer> computer = Computer.computerNumber();
        Score score = new Score();

        while (score.getStrike() != 3) {
            List<Integer> player = getPlayerNumber();
            countScore(player, computer, score);
            printScore(score);

            // 유효한 값이 입력되는지 확인하기 위한 출력
            System.out.println(computer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNumber = Player.playerNumber();
        return playerNumber;
    }

    public static void countScore(List<Integer> player, List<Integer> computer, Score score) {
        int strike = Score.countStrike(player, computer);
        int ball = Score.countBall(player, computer);
        score.setScore(strike, ball);
    }

    public static void printScore(Score score) {
        score.printGameResult(score.getStrike(), score.getBall());
    }

    public static boolean askExitOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();

        hasOneOrTwo(playerInput);

        if (playerInput.equals("2")) {
            return true;
        }
        return false;
    }

    public static void hasOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("숫자 1 또는 2를 입력하세요.");
        }
    }
}
