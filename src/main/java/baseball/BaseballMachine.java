package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballMachine {
    private final int[] numbers;
    private final UI ui;

    public BaseballMachine() {
        this.numbers = new int[3];
        this.ui = new UI();
    }

    public void start() {
        this.ui.startGame();

        do {
            this.insertNumbers();
            int ball;
            int strike;
            do {
                ball = 0;
                strike = 0;
                String userStrings = this.ui.insertNumber();

                int[] intArray = new int[3];
                char[] charArray = userStrings.toCharArray();
                if (charArray.length != 3) throw new IllegalArgumentException();
                for (int i = 0; i < 3; i++) {
                    intArray[i] = Character.getNumericValue(charArray[i]);
                }
                ;
                // ball strike check

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (intArray[i] == numbers[j]) {
                            if (i == j) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }
                }
                System.out.println(Arrays.toString(numbers));
                this.ui.gameResult(ball, strike);

            } while (strike != 3);
            this.ui.winGame();
        } while (this.ui.selectGameProgress().equals("1"));


    }

    public void insertNumbers() {
        // 초기화
        numbers[0] = numbers[1] = numbers[2] = 0;

        // 생성
        int temp = pickNumberInRange(1, 9);
        numbers[0] = temp;

        // 두번째 생성
        do {
            temp = pickNumberInRange(1, 9);
        } while (temp == numbers[0]);
        numbers[1] = temp;

        // 세번째 생성
        do {
            temp = pickNumberInRange(1, 9);
        } while (temp == numbers[0] || temp == numbers[1]);
        numbers[2] = temp;
    }

    public String getNumbers() {
        return Arrays.toString(numbers);
    }


}
