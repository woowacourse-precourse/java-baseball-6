package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public BaseBallGame() {
    }

    public void playGame() {
        do {
            game();
        } while (reStart());
    }

    private boolean reStart() {
        printRestartMessage();
        String input = readLine();
        validateInput(input);
        return input.equals(RESTART);
    }

    private void validateInput(String input) {
        if ((input.equals(RESTART)) && (input.equals(EXIT))) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }
    }

    private void printRestartMessage() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", RESTART, EXIT);
    }

    public void game() {
        RandomBalls randomBalls = RandomBalls.makeRandomBalls();
        GameResult result;
        printStartMessage();

        do {
            printInputMessage();
            String userInput = UserBalls.getUserInput();
            result = GameResult.compareBalls(randomBalls, UserBalls.makeUserBalls(userInput));
            printResultMessage(result);

        } while (!result.isAllStrikes());
    }

    private void printResultMessage(GameResult result) {
        System.out.println(result.getResultMessage());
    }

    private void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
