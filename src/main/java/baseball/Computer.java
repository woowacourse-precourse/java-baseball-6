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
    static void compareNumber(int number){
        int digit=1;
        strike = 0;
        ball = 0;
        while(number>0){
            int remainDigit = digitBoard[number%10];
            if (remainDigit > 0) {
                ball++;
            }
            if(remainDigit == digit) {
                ball--;
                strike++;
            }
            number /= 10;
            digit++;
        }
    }

    public static String getHint(int number) {
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
        if(strike<3){
            return false;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return true;
    }
}
