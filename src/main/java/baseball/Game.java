package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class Game {
    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    public Game() {
    }

    public void play() {
        do {
            game();
        } while (reGame());
    }

    public void game() {
        BallList computerBallList;
        Result result;
        computerBallList = BallList.makeRandomBallList();
        do {
            printUserInputMessage();
            result = Result.checkBallList(makeUserBallList(), computerBallList);
            printResult(result);
        } while (!result.isAllStrikes());
    }

    private BallList makeUserBallList() {
        BallList userBallList = null;
        while (userBallList == null) {
            String userInput = getUserInput();
            validateUserInput(userInput);
            try {
                userBallList = BallList.stringToBallList(userInput);
            } catch (NumberFormatException e) {
                printNumberFormatExceptionMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userBallList;
    }

    private Boolean reGame() {
        String input = "";
        while (invalidInput(input)) {
            printCheckRestartMessage();
            input = getUserInput();
        }
        return input.equals(CONTINUE);
    }

    private boolean invalidInput(String input) {
        return !input.equals(CONTINUE) && !input.equals(QUIT);
    }

    private void validateUserInput(String userInput) {
        if (checkUserInputLength(userInput)) {
            throw new IllegalArgumentException("입력값의 길이가 잘못되었습니다.");
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
        return str.length() != BallList.BALL_COUNT;
    }

    private void printNumberFormatExceptionMessage() {
        System.out.println("3개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니다.");
    }

    private void printCheckRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
