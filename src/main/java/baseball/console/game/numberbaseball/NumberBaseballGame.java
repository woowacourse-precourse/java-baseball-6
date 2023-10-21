package baseball.console.game.numberbaseball;

import baseball.console.game.numberbaseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    Computer computer;
    List<Integer> userNumbers;

    boolean isCorrect;

    public NumberBaseballGame() {
        computer = new Computer();
        userNumbers = new ArrayList<>();
        isCorrect = false;
    }

    public void start() {
        while (!isCorrect) {
            userPredict();
            isCorrect = matchTest(userNumbers, computer.getNumbers());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void userPredict() {
            String prediction = getUserPrediction();
            int predictedNumber = validateAndParse(prediction);
            numberToList(predictedNumber);
    }


    private void numberToList(int predictedNumber) {
        userNumbers.add(predictedNumber / 100);
        userNumbers.add(predictedNumber % 100 / 10);
        userNumbers.add(predictedNumber %10);
    }
    private String getUserPrediction() {
            printGameMessage("숫자를 입력해주세요: ");
            return Console.readLine();
    }

    private int validateAndParse(String userPrediction) throws IllegalArgumentException{
        int number;
        try {
            number = Integer.parseInt(userPrediction);

            if (number < 123) {
                throw new IllegalArgumentException("input is cannot be less than 123.");
            }
            if (number > 987) {
                throw new IllegalArgumentException("input is cannot be greater than 123.");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 정수가 아닙니다.", e);
        }
    }

    private boolean matchTest(List<Integer> userNumbers, List<Integer> targetNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (targetNumbers.get(i) == userNumbers.get(i))
                strike++;
            else {
                for (int j = 0; j < 3; j++) {
                    if (j != i && targetNumbers.get(i) == userNumbers.get(j)){
                        ball++;
                    }
                }
            }
        }

        if (ball==0 && strike==0) System.out.println("낫싱");
        else {
            String result = "";
            if (ball != 0) result += ball + "볼 ";
            if (strike != 0) result += strike + "스트라이크";
            System.out.println(result);
        }

        return strike == 3;
    }
    private void printGameMessage(String message) {
        System.out.println(message);
    }
}
