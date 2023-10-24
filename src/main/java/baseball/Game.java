package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public void startGame() {
        List<Integer> computerThreeDigitNumbers = Computer.createRandomComputerNumber();
        String computerStringNumber = computerNumberToString(computerThreeDigitNumbers);

        while (true) {
            List<Integer> userThreeDigitNumber = User.createUserNumber();
            String userStringNumber = Integer.toString(userThreeDigitNumber.get(0));

            int[] ballAndStrikeResult = calculateBallAndStrike(computerStringNumber, userStringNumber);

            int ball = ballAndStrikeResult[0];
            int strike = ballAndStrikeResult[1];

            printBallAndStrikeResult(ball, strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private String computerNumberToString(List<Integer> computerThreeDigitNumbers) {
        return computerThreeDigitNumbers.stream()
                .map(computerThreeDigitNumber -> computerThreeDigitNumber.toString())
                .collect(Collectors.joining());
    }

    private int[] calculateBallAndStrike(String computerStringNumber, String userStringNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computerStringNumber.length(); i++) {
            if (isStrike(computerStringNumber, userStringNumber, i)) {
                strike++;
            } else if (isBall(computerStringNumber, userStringNumber, i)) {
                ball++;
            }
        }
        return new int[]{ball, strike};
    }

    private boolean isStrike(String computerNumber, String userNumber, int index) {
        return computerNumber.charAt(index) == userNumber.charAt(index);
    }

    private boolean isBall(String computerNumber, String userNumber, int index) {
        return computerNumber.contains("" + userNumber.charAt(index));
    }

    private void printBallAndStrikeResult(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        if (ball != 0 && strike == 0) {
            System.out.printf("%d볼", ball);
        }
        if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.printf("낫싱");
        }
        System.out.println();
    }
}
