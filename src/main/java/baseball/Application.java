package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static String randomNumber;
    private static String inputNumber;
    private static int ball;
    private static int strike;
    private static boolean isOver;
    private static String restartOrEndFlag;
    private static boolean isSucceed;
    private static final String TERMINATE = "2";

    public static void main(String[] args) throws IllegalArgumentException {
        //TODO: 숫자 야구 게임 구현
        isOver = false;
        while (!isOver) {
            randomNumber = makeRandomNumber();
            isSucceed = false;
            while (!isSucceed) {
                isSucceed();
            }
            isOver();
        }
    }

    public static String makeRandomNumber() {
        String randomNumber= "";
        while (randomNumber.length() < 3) {
            String n = String.valueOf(Randoms.pickNumberInRange(1,10));
            if (!randomNumber.contains(n)) {
                randomNumber += n;
            }
        }
        return randomNumber;
    }

    public static int calculateStrikeCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if(randomNumber.charAt(i) == inputNumber.charAt(i)) {
                cnt++;
            };
        }
        return cnt;
    }

    public static int calculateBallCount() {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(inputNumber.substring(i, i + 1))
                 && randomNumber.charAt(i) != inputNumber.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void printAnswerHint() {
        strike = calculateStrikeCount();
        ball = calculateBallCount();
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
    }

    public static void isSucceed() {
        if (strike == 3) {
            isSucceed = true;
        }
    }

    public static void isOver() {
        if (restartOrEndFlag.equals(TERMINATE)) {
            isOver = true;
        }
    }


}