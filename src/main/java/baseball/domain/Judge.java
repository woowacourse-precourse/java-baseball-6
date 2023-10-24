package baseball.domain;

public class Judge {
    int[] getResult(int[] intArrayComputerNumber, int[] intArrayInputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (intArrayInputNumber[i] == intArrayComputerNumber[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        return new int[]{strike, ball};
    }
}
