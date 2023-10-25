package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private int[] randomNumbers;

    public void generateRandomNumber() {
        randomNumbers = new int[10];
        int count = 1;
        while (count <= 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (randomNumbers[randomNumber] == 0) {
                randomNumbers[randomNumber] = count;
                count++;
            }
        }
    }

    public void checkAnswer(int[] numbers) {
        for (int position = 1; position <= numbers.length; position++) {
            if (randomNumbers[numbers[position - 1]] == position) {
                Judgement.STRIKE.countSymbol();
            } else if (randomNumbers[numbers[position - 1]] != 0) {
                Judgement.BALL.countSymbol();
            } else {
                Judgement.NOTHING.countSymbol();
            }
        }
    }
}
