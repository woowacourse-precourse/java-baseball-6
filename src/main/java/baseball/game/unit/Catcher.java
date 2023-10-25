package baseball.game.unit;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Catcher {

	public static Catcher computerCatcher = new Catcher();

	private final List<Integer> answerBallLocation;

	private int judgeBall;
	private int judgeStrike;
	private int judgeOut;

	private Catcher() {
		answerBallLocation = new ArrayList<>();
	}

	public void readyGame() {
		judgeBall = 0;
		judgeStrike = 0;
		judgeOut = 0;
		setAnswerBallValue();
	}

	private void setAnswerBallValue() {
		answerBallLocation.clear();
		while (answerBallLocation.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!answerBallLocation.contains(randomNumber)) {
				answerBallLocation.add(randomNumber);
			}
		}
	}

	public void catchBall(Ball ball) {
		judgeBall = 0;
		judgeStrike = 0;
		judgeOut = 0;
		for (int i = 0; i < 3; i++) {
			judgeValue(i, ball.getValue(i));
		}
	}

	private void judgeValue(int sequence,int value) {
		if (answerBallLocation.get(sequence) == value) {
			judgeStrike++;
			return;
		}
		if (answerBallLocation.contains(value)) {
			judgeBall++;
			return;
		}
		judgeOut++;
	}

	public boolean judgeCatherWinRound() {
		if (judgeStrike == 3) {
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return false;
		}
		if (judgeOut == 3) {
			System.out.println("낫싱");
			return true;
		}
		StringBuffer sb = new StringBuffer();
		if (judgeBall > 0) {
			sb.append(judgeBall);
			sb.append("볼");
		}
		if (judgeStrike > 0) {
			if (judgeBall > 0) {
				sb.append(" ");
			}
			sb.append(judgeStrike);
			sb.append("스트라이크");
		}
		System.out.println(sb.toString());
		return true;
	}
}
