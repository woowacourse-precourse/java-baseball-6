package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int firstPositionAnswer;
    private int secondPositionAnswer;
    private int thirdPositionAnswer;

    public Computer() {

        while (true) {

            generateAnswer();
            System.out.println("new game 생성 : " + this.firstPositionAnswer + "" + this.secondPositionAnswer + "" + this.thirdPositionAnswer);

            boolean isCanUse = isCanUseThisAnswer();

            if (isCanUse) {
                break;
            }
        }

    }

    private boolean isCanUseThisAnswer() {
        return !(
                this.firstPositionAnswer == this.secondPositionAnswer ||
                this.firstPositionAnswer == this.thirdPositionAnswer ||
                this.secondPositionAnswer == this.thirdPositionAnswer
        );
    }

    private void generateAnswer() {
        this.firstPositionAnswer = Randoms.pickNumberInRange(1, 9);
        this.secondPositionAnswer = Randoms.pickNumberInRange(1, 9);
        this.thirdPositionAnswer = Randoms.pickNumberInRange(1, 9);
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
