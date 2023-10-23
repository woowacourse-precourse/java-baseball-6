package baseball;

/* 플레이어가 제시한 숫자를 판정하고 결과를 반환 */
public class BaseballUmpire {
	public int umpireBall(String com, String user) {
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

	private boolean isEquals(String com, String user, int i) {
		// com의 i번째 문자와 user의 i번째 문자가 서로 같다면 true
		return com.charAt(i) == user.charAt(i);
	}

	private boolean isContains(String com, String user, int i) {
		// com 문자열이 user의 i번째 문자를 포함하면 true
		return com.contains(Character.toString(user.charAt(i)));
	}
}
