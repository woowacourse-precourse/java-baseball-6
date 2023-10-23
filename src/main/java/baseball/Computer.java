package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final String nothing = "낫싱";
    private final String strike = "스트라이크";
    private final String ball = "볼";

    private int[] numbers;

    public Computer() {
        numbers = new int[3];
    }

    public void init() {
        int size = 0;

        while (size != 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            boolean flag = true;

            for (int i = 0; i < size; i++) {
                if (numbers[i] == num) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                numbers[size++] = num;
        }
    }

    public boolean check(String input) {
        int ballNum = 0, strikeNum = 0;

        for (int i = 0; i < 3; i++) {
            int number = input.charAt(i) - '0';

            for (int j = 0; j < 3; j++) {
                if (number == numbers[j]) {
                    if (i == j)
                        strikeNum++;
                    else
                        ballNum++;
                }
            }
        }

        print(ballNum, strikeNum);

        return strikeNum == 3;
    }

    private void print(int ballNum, int strikeNum) {
        if (ballNum == 0 && strikeNum == 0) {
            System.out.println(nothing);
            return;
        }

        if (ballNum != 0 && strikeNum != 0) {
            System.out.println(ballNum + ball + " " + strikeNum + strike);
            return;
        }

        if (ballNum == 0)
            System.out.println(strikeNum + strike);

        else
            System.out.println(ballNum + ball);
    }
}
