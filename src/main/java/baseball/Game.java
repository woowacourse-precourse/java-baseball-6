package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private final int firstPositionAnswer;
    private final int secondPositionAnswer;
    private final int thirdPositionAnswer;

    public Game() {
        firstPositionAnswer = Randoms.pickNumberInRange(1, 9);
        secondPositionAnswer = Randoms.pickNumberInRange(1, 9);
        thirdPositionAnswer = Randoms.pickNumberInRange(1, 9);
        System.out.println("new game 생성 : " +firstPositionAnswer+""+secondPositionAnswer+""+thirdPositionAnswer);
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

}
