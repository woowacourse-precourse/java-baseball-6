package baseball.model;

public class Game_logic {

	private int strike;
	private int ball;

	public int getstrike() {
		return strike;
	}
	// 초기화
	private void reset_Score() {
		strike = 0;
		ball = 0;
	}

	// 스트라이크, 볼 개수 반환 메서드
	public int[] getScore(String Player_Number, String Com_Number) {
		reset_Score();
		Ball_case(Player_Number, Com_Number);
		Strike_case(Player_Number, Com_Number);
		logic();

		return new int[] { ball, strike };
	}

	// 볼 로직
	public void Ball_case(String Player_Number, String Com_Number) {
		for (int i = 0; i < 3; i++) {
			if (Com_Number.contains(Character.toString(Player_Number.charAt(i)))) {
				ball += 1;
			}
		}
	}

	// 스트라이크 로직
	public void Strike_case(String Player_Number, String Com_Number) {
		for (int i = 0; i < 3; i++) {
			if (Com_Number.charAt(i) == Player_Number.charAt(i)) {
				strike += 1;
			}
		}

	}

	// 스트라이크 중첩 해결
	private void logic() {
		ball = ball - strike;
	}

	

}
