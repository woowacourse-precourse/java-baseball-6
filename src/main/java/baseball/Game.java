package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private User user;
    private Computer computer;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
        playBaseBallGame();
    }

    public int countStrike() {
        int result = 0;
        String userNumber = user.getUserNumber();
        ArrayList<Integer> computerNumber = computer.getComputerNumber();

        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) - 48 == computerNumber.get(i)) {
                result++;
            }
        }
        return result;
    }

    public int countBall() {
        int result = 0;
        String userNumber = user.getUserNumber();
        ArrayList<Integer> computerNumber = computer.getComputerNumber();

        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) - 48 != computerNumber.get(i) && computerNumber.contains(userNumber.charAt(i) - 48)) {
                result++;
            }
        }
        return result;
    }

    private void diplayUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void displayStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    private static boolean isWantToQuitGame() {
        int exitCommand = Integer.parseInt(Console.readLine());
        return exitCommand == 2;
    }

    private static void displayCorrectAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


    private String inferHint() {
        int strike = countStrike();
        int ball = countBall();
        return getResult(strike, ball);
    }

    private String getResult(int strike, int ball) {
        if (isNothing(strike, ball)) {
            return "낫싱";
        }
        String strikeResult = getGameResult("스트라이크", strike);
        String ballResult = getGameResult("볼", ball);
        return ballResult + strikeResult;
    }

    private String getGameResult(String type, int count) {
        if (count <= 0) return "";

        return switch (type) {
            case "스트라이크" -> String.format("%d 스트라이크", count);
            case "볼" -> String.format("%d 볼 ", count);
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private boolean isAnswer(String hint) {
        return hint.equals("3 스트라이크");
    }

    private void playBaseBallGame() {
        displayStartGame();

        while (true) {
            try {
                diplayUserInput();
                user.inputUserNumber();

                String hint = inferHint();
                System.out.println(hint);

                if (isAnswer(hint)) {
                    displayCorrectAnswerMessage();
                    if (isWantToQuitGame()) {
                        break;
                    }
                    this.computer = new Computer();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                return;
//                System.exit(1); -> 프로그램 종료 시 System.exit()를 호출하지 않는다.
            }
        }
    }
}