package baseball.util;

//숫자 비교
public class NumberCompare {
    private static int ball;
    private static int strike;

    public static int[] resultBallStrike(String userNumber, String computerNumber){
        ball =0;
        strike =0;
        CountStrike(userNumber, computerNumber);
        CountBall(userNumber, computerNumber);
        ball = ball - strike;
        return new int[]{ball, strike};
    }

    public static void CountBall(String userNumber, String computerNumber){
        for (int i = 0; i < userNumber.length(); i++) {
            if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball ++;
            }
        }
    }

    public static void CountStrike(String userNumber, String computerNumber){
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strike ++;
            }
        }
    }

}
