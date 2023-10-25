package baseball.judge;

import java.util.ArrayList;
import java.util.List;

public class Judge {
	private int strikes;
	private int balls;
	private boolean finish;
	private List<Integer> strikeZone;

	public Judge() {
		this.strikes = 0;
		this.balls = 0;
		this.finish = false;
	}

	public void setNumbers(List<Integer> numbers) {
		this.strikeZone = new ArrayList<>(numbers);
		finish = false;
	}

	public boolean callPitch() {
		if (this.strikes == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			finish = true;
		}
		this.strikes = 0;
		this.balls = 0;
		return (!finish);
	}

	public void judgePitch(ArrayList<Integer> pitchBalls) {
		for (int i = 0; i < pitchBalls.size(); i++) {
			int num = pitchBalls.get(i);
			if (strikeZone.get(i) == num) {
				this.strikes++;
				continue;
			}
			if (strikeZone.contains(num)) {
				this.balls++;
			}
		}
	}

	public void callSignal() {
		StringBuilder sb = new StringBuilder();
		if (this.balls > 0) {
			sb.append(this.balls).append("볼 ");
		}
		if (this.strikes > 0) {
			sb.append(this.strikes).append("스트라이크 ");
		}
		if (this.balls == 0 && this.strikes == 0) {
			sb.append("낫싱");
		}
		System.out.println(sb);
	}
}
