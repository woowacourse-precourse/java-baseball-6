package baseball.logic;

public class Logic {

    public int[] splitNumber(int num) {
        int[] splitNums = new int[3];
        splitNums[0] = num / 100;
        splitNums[1] = (num / 10) % 10;
        splitNums[2] = num % 10;

        return splitNums;
    }

    private boolean contains(int[] array, int value) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    public int[] scoringResult(int inputAnswer, int correctAnswer) {
        int strike = 0;
        int ball = 0;

        int[] splitInputAnswer = splitNumber(inputAnswer);
        int[] splitCorrectAnswer = splitNumber(correctAnswer);

        for (int i = 0; i < 3; i++) {
            if (splitInputAnswer[i] == splitCorrectAnswer[i]) {
                strike++;
            } else if (contains(splitCorrectAnswer, splitInputAnswer[i])) {
                ball++;
            }
        }

        int[] scores = {strike, ball};
        return scores;
    }
}
