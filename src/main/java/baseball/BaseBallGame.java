package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class BaseBallGame {

    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    public BaseBallGame() {
    }

    public void play() {
        do {
            game();
        } while (reGame());
    }

    public void game() {
        Balls comBalls;
        Result result;
        comBalls = Balls.makeRandomBalls();
        do {
            printUserInputMessage();
            result = Result.checkBalls(makeUserBalls(), comBalls);
            printResult(result);
        } while (!result.isAllStrikes());
    }

    private Balls makeUserBalls() {
        Balls userBalls = null;
        while (userBalls == null) {
            String userInput = getUserInput();
            validateUserInput(userInput);
            try {
                userBalls = Balls.stringToBalls(userInput);
            } catch (NumberFormatException e) {
                printFormatExceptionMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userBalls;
    }

    private Boolean reGame() {
        String input = "";
        while (invalidInput(input)) {
            printCheckRestartMessage();
            input = getUserInput();
        }
        printCheckRestartExceptionMessage();
        return input.equals(CONTINUE);
    }

    private boolean invalidInput(String input) {
        return !input.equals(CONTINUE) && !input.equals(QUIT);
    }

    private void validateUserInput(String userInput) {
        if (checkUserInputLength(userInput)) {
            throw new IllegalArgumentException("입력값의 길이가 잘못 되었습니다.");
        }
    }

    private String getUserInput() {
        return readLine();
    }

    private void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printResult(Result result) {
        System.out.println(result.getResultMessage());
    }

    private Boolean checkUserInputLength(String str) {
        return str.length() != Balls.BALLS_COUNT;
    }

    private void printFormatExceptionMessage() {
        System.out.printf("%d개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니다.%n", Balls.BALLS_COUNT);
    }

    private void printCheckRestartExceptionMessage() {
        System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요.");
    }

    private void printCheckRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}