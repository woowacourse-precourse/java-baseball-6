package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;

public class GameComparator {
    private static final int NO_COUNT = 0;

    public boolean isNothing(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput) {
        HashSet<Integer> set = new HashSet<>(computerNumber);
        for (int num : playerInput) {
            if (set.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEndGame(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (!computerNumber.get(i).equals(playerInput.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int countStrikes(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput) {
        int strikeCount = NO_COUNT;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i).equals(playerInput.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBalls(ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput) {
        int ballCount = NO_COUNT;
        for (int i = 0; i < computerNumber.size(); i++) {
            ballCount += countMatchForIndex(i, computerNumber, playerInput);
        }
        return ballCount;
    }

    private int countMatchForIndex(int index, ArrayList<Integer> computerNumber, ArrayList<Integer> playerInput) {
        int count = NO_COUNT;
        for (int j = 0; j < playerInput.size(); j++) {
            if (index != j && computerNumber.get(index).equals(playerInput.get(j))) {
                count++;
            }
        }
        return count;
    }

}

