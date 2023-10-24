package baseball;

/* 플레이어가 제시한 숫자를 판정하고 결과를 반환 */
public class BaseballUmpire {
    private int ball;
    private int strike;

    public BaseballUmpire() {
        ball = 0;
        strike = 0;
    }

    public int[] umpire(String com, String user) {
        ball = umpireBall(com, user);
        strike = umpireStrike(com, user);
        return new int[]{ball, strike};
    }

    private int umpireBall(String com, String user) {
        int ball = 0;
        for (int i = 0; i < user.length(); i++) {
            if (isContains(com, user, i) && !isEquals(com, user, i)) {
                ball++;
            }
        }
        return ball;
    }

    private int umpireStrike(String com, String user) {
        int strike = 0;
        for (int i = 0; i < user.length(); i++) {
            if (isEquals(com, user, i)) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isEquals(String com, String user, int index) {
        // com의 index번째 문자와 user의 index번째 문자가 서로 같다면 true
        return com.charAt(index) == user.charAt(index);
    }

    private boolean isContains(String com, String user, int index) {
        // com 문자열이 user의 index번째 문자를 포함하면 true
        return com.contains(Character.toString(user.charAt(index)));
    }

    public int getStrike() {
        return this.strike;
    }
}
