package baseball;

import baseball.validators.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private User user;
    private Computer computer;
    private final List<Validator> validators;

    public Game(List<Validator> validators) {
        this.computer = new Computer();
        this.user = new User();
        this.validators = validators;
    }

    private void validateUserInput() {
        for (Validator validator : validators) {
            validator.validate(user.getUserNumber());
        }
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

        String strikeResult = getGameResult(GameHintType.STRIKE, strike);
        String ballResult = getGameResult(GameHintType.BALL, ball);
        return ballResult + strikeResult;
    }

    private String getGameResult(GameHintType hintType, int count) {
        if (count <= 0) return "";

        return switch (hintType) {
            case STRIKE -> String.format("%d%s", count, hintType.getLabel());
            case BALL -> String.format("%d%s ", count, hintType.getLabel());
        };
    }

    private boolean isNothing(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private boolean isAnswer(String hint) {
        return hint.equals("3스트라이크");
    }

    private void playBaseBallGame() {
        displayStartGame();

        while (true) {
            try {
                diplayUserInput();
                user.inputUserNumber();
                validateUserInput();

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
                throw e;
            }
        }
    }

    public void startGame() {
        playBaseBallGame();
    }

    public enum GameHintType {
        STRIKE("스트라이크"),
        BALL("볼");

        private final String label;

        GameHintType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }
    }
}