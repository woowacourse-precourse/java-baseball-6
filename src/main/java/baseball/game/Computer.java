package baseball.game;

import baseball.view.Console;

import java.util.List;
import java.util.stream.IntStream;


public class Computer {

    private static List<Integer> computerNumber;


    public Computer() {

    }

    public void createRandomNumber() {

        computerNumber = Console.input3DigitRandomNumber();

    }

    public BaseBallGameResult calculate(List<Integer> userNumber) {
        int strikeCount = 0;
        int[] ballCounts = new int[10];


        for (int i : IntStream.range(0, 3).toArray()) {
            int selectedComputerNumber = computerNumber.get(i);
            int selectedUserNumber = userNumber.get(i);

            if (validateStrike(selectedComputerNumber, selectedUserNumber)) {
                strikeCount++;
                continue;
            }
            ballCounts[selectedComputerNumber]++;
            ballCounts[selectedUserNumber]++;
        }

        int ballCount = calculateBallCount(ballCounts);

        return BaseBallGameResult.create(strikeCount, ballCount);

    }

    private int calculateBallCount(int[] ballCounts) {
        int result=0;
        for (int i: ballCounts){
            if (i==2) {
                result++;
            }
        }
        return result;
    }

    private boolean validateStrike(int computerNumber, int userNumber) {
        return computerNumber == userNumber;
    }
}
