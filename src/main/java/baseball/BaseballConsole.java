package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballConsole {

    public static void startBaseballShell() {
        while (true) {
            startNewGame();
            if (isStop()) {
                break;
            }
        }
    }

    private static boolean isStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = getInput("", "[12]");
        return answer.equals("2");
    }

    private static void startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame game = new BaseballGame();
        while (true) {
            String answer = getInput("숫자를 입력해주세요 : ", "[1-9]{3}");
            game.setUserNumbers(answer);
            System.out.println(game.getBallScoreMessage());
            if (game.isWin()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }


    public static String getInput(String message, String regex) {
        System.out.print(message);
        String userInput = Console.readLine();
        if (!userInput.matches(regex)) {
            throw new IllegalArgumentException(userInput + "은 형식에 맞지 않습니다.");
        }
        return userInput;
    }

}
