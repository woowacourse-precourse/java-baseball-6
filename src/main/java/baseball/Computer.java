package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    private int firstPositionAnswer;
    private int secondPositionAnswer;
    private int thirdPositionAnswer;

    public static Computer getComputerWithRandomAnswer(){
        return new Computer();
    }

    private Computer() {
        generateAnswer();
    }

    private void generateAnswer() {

        HashSet<Integer> answers = new HashSet<>();

        while (answers.size() < 3) {
            answers.add(Randoms.pickNumberInRange(1, 9));
        }

        Iterator<Integer> iterator = answers.iterator();
        this.firstPositionAnswer = iterator.next();
        this.secondPositionAnswer = iterator.next();
        this.thirdPositionAnswer = iterator.next();
    }

    public int getBallCount(int userInput) {
        int ballCount = 0;

        int userInputFirstPosition = (userInput / 100) % 100;
        int userInputSecondPosition = (userInput / 10) % 10;
        int userInputThirdPosition = userInput % 10;

        if (userInputFirstPosition == secondPositionAnswer || userInputFirstPosition == thirdPositionAnswer) {
            ballCount++;
        }
        if (userInputSecondPosition == firstPositionAnswer || userInputSecondPosition == thirdPositionAnswer) {
            ballCount++;
        }
        if (userInputThirdPosition == firstPositionAnswer || userInputThirdPosition == secondPositionAnswer) {
            ballCount++;
        }

        return ballCount;
    }

    public int getStrikeCount(int userInput) {
        int strikeCount = 0;

        int userInputFirstPosition = (userInput / 100) % 100;
        int userInputSecondPosition = (userInput / 10) % 10;
        int userInputThirdPosition = userInput % 10;

        if (userInputFirstPosition == firstPositionAnswer) {
            strikeCount++;
        }
        if (userInputSecondPosition == secondPositionAnswer) {
            strikeCount++;
        }
        if (userInputThirdPosition == thirdPositionAnswer) {
            strikeCount++;
        }

        return strikeCount;
    }

    public boolean isNothing(int userInput) {
        return getBallCount(userInput) + getStrikeCount(userInput) == 0;
    }

    public boolean isPlayerWin(int userInput) {
        return getStrikeCount(userInput) == 3;
    }

}
