package baseball;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballMachine {
    private final int[] randomValueArray;
    private final UI ui;

    public BaseballMachine() {
        this.randomValueArray = new int[3];
        this.ui = new UI();
    }

    public void start() {
        this.ui.startGame();

        while (true) {
            // 랜덤 값 생성
            this.createRandomValue();

            while (true) {
                String userInput = this.ui.insertNumber();
                int[] userInputArray = this.userInputConvertIntArray(userInput);
                int[] baseballTargetCount = this.ballAndStrikeCount(userInputArray);

                System.out.println(Arrays.toString(randomValueArray));
                this.ui.gameResult(baseballTargetCount);

                if (baseballTargetCount[1] == 3) break;

            }
            this.ui.winGame();
            String userChoicePostGameString = this.ui.selectGameProgress();
            int userChoicePostGame = this.convertUserChoicePostGame(userChoicePostGameString);
            if (userChoicePostGame == 2) break;


        }

    }

    private void createRandomValue() {
        randomValueArray[2] = randomValueArray[1] = randomValueArray[0] = 0;
        for (int i = 0; i < randomValueArray.length; i++) {
            int temp;
            boolean isDuplicate;

            do {
                isDuplicate = false;
                temp = pickNumberInRange(1, 9);

                for (int j = 0; j < i; j++) {
                    if (randomValueArray[j] == temp) {
                        isDuplicate = true;
                        break;
                    }
                }
            } while (isDuplicate);

            randomValueArray[i] = temp;
        }
    }

    private int[] userInputConvertIntArray(String userInput) {

        int[] intArray = new int[userInput.length()];
        char[] charArray = userInput.toCharArray();

        if (charArray.length != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            if (charArray[i] < '1' || charArray[i] > '9') throw new IllegalArgumentException();
            intArray[i] = Character.getNumericValue(charArray[i]);
            for (int j = 0; j < i; j++) {
                if (intArray[i] == intArray[j]) throw new IllegalArgumentException();
            }
        }
        return intArray;
    }

    private int[] ballAndStrikeCount(int[] userInputArray) {
        int[] baseballTargetCount = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userInputArray[i] == randomValueArray[j]) {
                    if (i == j) {
                        baseballTargetCount[1]++;
                    } else {
                        baseballTargetCount[0]++;
                    }
                }
            }
        }
        return baseballTargetCount;
    }

    private int convertUserChoicePostGame(String userInput) {
        if (userInput.length() != 1) throw new IllegalArgumentException();
        char[] charArray = userInput.toCharArray();
        if (charArray[0] < '1' || charArray[0] > '2') throw new IllegalArgumentException();
        return Character.getNumericValue(charArray[0]);
    }
}
