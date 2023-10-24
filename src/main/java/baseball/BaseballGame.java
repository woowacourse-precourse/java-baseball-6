package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class BaseballGame {

    private static final int MAX_NUMBER_LENGTH = BaseballValues.MAX_NUMBER_LENGTH.getValue();
    private final Computer computer = new Computer();
    private final Player player = new Player();
    
    void start() {

        int result = 0;

        computer.initNumbers();

        while (result != 3) {

            player.initNumbers();

            int[] gameResult = calculateResult();

            printGameResultMessage(gameResult);

            result = gameResult[0];
        }

        checkAgain();
    }

    private int[] calculateResult() {

        int[] result = {0, 0};

        result[0] = calculateStrike();
        result[1] = calculateBall() - result[0];

        return result;
    }

    private int calculateBall() {
        int ball = 0;

        List<Integer> playerNumbers = player.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        for (int playerNumber : playerNumbers) {
            ball += checkContainNumber(computerNumbers, playerNumber);
        }

        return ball;
    }

    private int checkContainNumber(List<Integer> computerNumbers, int userNumber) {
        if (computerNumbers.contains(userNumber)) {
            return 1;
        }

        return 0;
    }

    private int calculateStrike() {
        int strike = 0;

        List<Integer> playerNumbers = player.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = playerNumbers.get(i);

            strike += checkEqualsNumber(computerNumber, userNumber);
        }

        return strike;
    }

    private int checkEqualsNumber(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }

        return 0;
    }

    private void printGameResultMessage(int[] gameResult) {

        int strike = gameResult[0];
        int ball = gameResult[1];

        String gameResultMessage = makeResultMessage(strike, ball);
        System.out.println(gameResultMessage);
    }

    private String makeResultMessage(int strike, int ball) {

        String resultMessage = ball + "볼 " + strike + "스트라이크";

        if (strike == 3) {
            resultMessage = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            return resultMessage;
        }

        if (strike == 0 && ball == 0) {
            resultMessage = "낫싱";
            return resultMessage;
        }

        if (strike == 0) {
            resultMessage = ball + "볼";
            return resultMessage;
        }

        if (ball == 0) {
            resultMessage = strike + "스트라이크";
            return resultMessage;
        }

        return resultMessage;
    }

    private void checkAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int answer = 2;

        try {
            String inputAnswer = readLine();

            if (inputAnswer.length() != 1) {
                throw new IllegalArgumentException("잘못 입력하셨습니다.");
            }

            answer = Integer.parseInt(inputAnswer);

            if (answer != 1 && answer != 2) {
                throw new IllegalArgumentException("잘못 입력하셨습니다.");
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }

        if (answer == 1) {
            start();
        }

    }

}
