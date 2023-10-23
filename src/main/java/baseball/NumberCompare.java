package baseball;

/**
 * 나는 숫자를 전달해주면 숫자를 비교하고 결과값을 출력해줄게
 */

public class NumberCompare {
    private static final int CHANCE = 3;
    private int balls;
    private int strikes;


    public int[] calculateBallAndStrike(String userNumber, String computerNumber) {
        resetCount();
        CountStrike(userNumber, computerNumber);
        CountBall(userNumber, computerNumber);
        return new int[]{balls, strikes};
    }

    public void resetCount() {
        balls = 0;
        strikes = 0;
    }


    public void CountBall(String userNumber, String computerNumber) {
        for (int i = 0; i < CHANCE; i++) {
            if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                balls++;
            }
        }
        balls = balls - strikes;
    }

    public void CountStrike(String userNumber, String computerNumber) {
        for (int i = 0; i < CHANCE; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strikes++;
            }
        }
    }
}