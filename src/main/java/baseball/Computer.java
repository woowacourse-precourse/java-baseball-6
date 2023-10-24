package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final int[] numberArray;

    public Computer() {
        this.numberArray = new int[3];
        createRandomNumbers();
    }

    public void createRandomNumbers() {
        int[] numberBox = new int[10];

        for (int i = 0; i < numberArray.length; i++) {
            while (true) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (numberBox[randomNumber] == 0) {
                    numberBox[randomNumber] = 1;
                    numberArray[i] = randomNumber;
                    break;
                }
            }
        }
    }

    public Result check(String answer) {
        char[] answerArray = answer.toCharArray();

        int ball = 0;
        int strike = 0;
        for (int numIdx = 0; numIdx < numberArray.length; numIdx++) {
            for (int answerIdx = 0; answerIdx < answerArray.length; answerIdx++) {
                if (numberArray[numIdx] == Character.getNumericValue(answerArray[answerIdx])) {
                    if (numIdx == answerIdx) {
                        strike++;
                    } else {
                        ball++;
                    }
                    break;
                }
            }
        }
        return new Result(ball, strike);
    }

    public int[] getNumberArray() {
        return numberArray;
    }
}
