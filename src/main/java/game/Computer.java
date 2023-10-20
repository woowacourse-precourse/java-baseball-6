package game;

import baseball.Output;
import camp.nextstep.edu.missionutils.Randoms;
import constants.MessageConstants;
import constants.NumberConstants;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    private final String numbers;
    private boolean finish;

    public Computer() {
        numbers = getRandomNumbers();
        finish = false;
    }

    public void compareInput(String input) {
        int ballCounts = ballCounts(input);
        int strikeCounts = strikeCounts(input);

        printResultMessage(ballCounts, strikeCounts);

        if (strikeCounts == NumberConstants.MAX_STRIKE) {
            System.out.println(MessageConstants.GAME_FINISH_MESSAGE);
            finish = true;
        }
    }

    private void printResultMessage(int ballCounts, int strikeCounts) {
        if (ballCounts == NumberConstants.ZERO && strikeCounts == NumberConstants.ZERO) {
            Output.printMessage(MessageConstants.NOTHING_MESSAGE);
            return;
        }
        StringBuilder message = new StringBuilder();

        if (ballCounts != NumberConstants.ZERO) {
            message.append(ballCounts).append(MessageConstants.BALL_MESSAGE).append(" ");
        }
        if (strikeCounts != NumberConstants.ZERO) {
            message.append(strikeCounts).append(MessageConstants.STRIKE_MESSAGE);
        }

        Output.printMessage(message.toString());
    }

    private int strikeCounts(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (numbers.charAt(i) == input.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private int ballCounts(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (isBall(i, input)) {
                count++;
            }
        }

        return count;
    }

    private boolean isBall(int index, String input) {
        char number = input.charAt(index);
        String numberString = String.valueOf(number);
        return numbers.charAt(index) != number && numbers.contains(numberString);
    }

    private String getRandomNumbers() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < NumberConstants.MAX_BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
            set.add(randomNumber);
        }

        return setToString(set);
    }

    private String setToString(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (int num : set) {
            sb.append(num);
        }
        return sb.toString();
    }

    public boolean isFinish() {
        return finish;
    }
}
