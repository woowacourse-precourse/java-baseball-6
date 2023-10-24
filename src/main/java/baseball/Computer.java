package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static int[] digitBoard = null;
    private static int strike = 0;
    private static int ball = 0;

    public static void setRandomNumber() {
        int digit = 3;
        digitBoard = new int[MIN_NUMBER + MAX_NUMBER];

        while (digit >= 1) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (digitBoard[randomNumber] == 0) {
                digitBoard[randomNumber] = digit--;
            }
        }
    }

    static void compareNumber(final String number){
        int currentDigit=4;
        for(char digit: number.toCharArray()){
            currentDigit--;
            if(digitBoard[digit-'0']==currentDigit){
                strike++;
                continue;
            }
            if(digitBoard[digit-'0']>0){
                ball++;
            }
        }
    }

    public static String getHint(final String number) {
        strike = 0;
        ball = 0;
        compareNumber(number);
        if(strike == 0 && ball == 0) {
            return "낫싱";
        }

        String result = (ball>0 ? (ball + "볼") : "");
        if(strike>0) {
            result += (ball>0 ? " " : "") + strike + "스트라이크";
        }

        return result;
    }

    public static boolean isCorrect() {
        return strike == 3;
    }
}
