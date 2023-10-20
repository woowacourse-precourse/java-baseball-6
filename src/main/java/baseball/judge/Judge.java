package baseball.judge;

import baseball.givennum.GivenNum;

public class Judge {
    private int[] receivedNum;

    public Judge(GivenNum givenNum) {
        this.receivedNum = givenNum.getComputerNumbersAsArray();
    }

    public String strikesAndBalls(int[] userNum) {
        String result = "";

        if (userNum.length != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해 주세요.");
        }

        int strikes = 0;
        int balls = 0;
        boolean[] countedAsStrike = new boolean[3];
        boolean[] countedAsBall = new boolean[3];

        for (int i = 0; i < 3; i++) {
            if (userNum[i] == receivedNum[i]) {
                strikes++;
                countedAsStrike[i] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!countedAsStrike[i] && !countedAsStrike[j] && userNum[i] == receivedNum[j]) {
                    balls++;
                    countedAsBall[i] = true;
                }
            }
        }

        if (strikes == 3) {
            return "3스트라이크";
        }

        if (balls > 0) {
            result += balls + "볼";
        }
        if (strikes > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += strikes + "스트라이크";
        }
        if (strikes == 0 && balls == 0) {
            result = "낫싱";
        }
        return result;
    }
}