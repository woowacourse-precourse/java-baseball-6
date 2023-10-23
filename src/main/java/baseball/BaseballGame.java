package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final int MAX_NUMBER_LENGTH = BaseballValues.MAX_NUMBER_LENGTH.getValue();
    private static final int MIN_NUMBER = BaseballValues.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = BaseballValues.MAX_NUMBER.getValue();

    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers;

    BaseballGame() {
        computerNumbers = new ArrayList<>();
        playerNumbers = new ArrayList<>();
    }

    BaseballGame(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
    }


    void start() {

        initComputerNumbers();

        int result = 0;

        while (result != 3) {

            initUserNumbers();

            int[] gameResult = calculateResult();

            printGameResultMessage(gameResult);

            result = gameResult[0];
        }

        checkAgain();
    }

    private void initComputerNumbers() {

        computerNumbers.clear();

        while (computerNumbers.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    private void initUserNumbers() {

        playerNumbers.clear();

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = readLine();

        if (inputNumbers.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력한 숫자 길이가 맞지 않습니다.");
        }

        for (int i = 0; i < inputNumbers.length(); i++) {
            int number = Character.getNumericValue(inputNumbers.charAt(i));

            if (MIN_NUMBER > number || number > MAX_NUMBER) {
                throw new IllegalArgumentException("입력한 문자는 숫자가 아닙니다.");
            }

            playerNumbers.add(number);
        }
    }

    private int[] calculateResult() {

        int[] result = {0, 0};

        result[0] = calculateStrike();
        result[1] = calculateBall() - result[0];

        return result;
    }

    private int calculateBall() {
        int ball = 0;

        for (int userNumber : playerNumbers) {
            if (computerNumbers.contains(userNumber)) {
                ball++;
            }
        }

        return ball;
    }

    private int calculateStrike() {
        int strike = 0;

        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = playerNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
            }
        }

        return strike;
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
