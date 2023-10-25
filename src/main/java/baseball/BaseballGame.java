package baseball;

import java.util.List;

public class BaseballGame {
	private List<Integer> userAnswer;
	private List<Integer> answer;
	private int ball;
	private int strike;
	
	public BaseballGame(List<Integer> userAnswer, List<Integer> answer) {
		this.userAnswer = userAnswer;
		this.answer = answer;
		this.ball = 0;
		this.strike = 0;
	}
	
	// 볼인지 확인
	public int getBall() {
		for (int i = 0; i < 3; i++) {
		    for (int j = 0; j < 3; j++) {
		    	if(this.userAnswer.get(i) == this.answer.get(j)) {
					this.ball ++;
				}
		    }
		}
		return this.ball - this.strike;
	}
	
	// 스트라이크 확인
	public int getStrike() {
		for(int i = 0; i < 3; i ++) {
			if(this.userAnswer.get(i) == this.answer.get(i)) {
				this.strike ++;
			}
		}
		return this.strike;
	}
}
