package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {

    private final String numbers;

    public Computer() {
        numbers = getRandomNumbers();
    }

    public void compareInput(String input) {
        int ballCounts = ballCounts(input);
        int strikeCounts = strikeCounts(input);
        
        String message = getResultsMessage(ballCounts, strikeCounts);
        System.out.println(message);
    }
    
    private String getResultsMessage(int ballCounts, int strikeCounts) {
        if (ballCounts == 0 && strikeCounts == 0) {
            return Constants.NOTHING_MESSAGE;
        }
        StringBuilder sb = new StringBuilder();
        
        if (ballCounts != 0) {
            sb.append(ballCounts).append(Constants.BALL_MESSAGE).append(" ");
        }
        if (strikeCounts != 0) {
            sb.append(strikeCounts).append(Constants.STRIKE_MESSAGE);
        }
        
        return sb.toString();
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

        while (set.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
}
