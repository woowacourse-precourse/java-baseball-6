package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameIO {

    public static void gameResultPrint(int strikeCount, int ballCount) {
        //결과값 출력
        if (strikeCount + ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        String result = "";
        if (ballCount > 0) {
            result = ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }

        System.out.println(result);
    }

    static void gameRestartPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void gameStartPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void gameInputPrint() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    static Balls scanGameBalls() {
        String ballsStr = Console.readLine();
        validationInput(ballsStr);

        return new Balls(
                new Ball(ballsStr.charAt(0) - '0')
                , new Ball(ballsStr.charAt(1) - '0')
                , new Ball(ballsStr.charAt(2) - '0'));
    }

    private static void validationInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
