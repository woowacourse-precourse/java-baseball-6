package baseballgame;

import java.util.List;

public class BaseballResultCalculator {
	private int strikes = 0;
	private int ball = 0;
	
	
	// 볼의 숫자를 얻는 메소드
	public int getBall() {
		return ball;
	}
	
	// 스트라이크 숫자를 얻은 메소드
	public int getStrike() {
		return strikes;
	}
	
	// 컴퓨터의 숫자와 사용자의 숫자를 대조해 스트라이크와 볼의 숫자를 증가시키는 메소드
	public String calculateBallAndStrike(List<Integer> user, List<Integer> computer) {
		this.strikes = 0;
		this.ball = 0;
		
		for(int i =0; i< user.size(); i++) {
			if(user.get(i).equals(computer.get(i))) {
				strikes++;
			}
			else if(computer.contains(user.get(i))){
				ball++;
			}
		}
		return getResultString();
	}
	// 각 결과를 반환하는 메소드	
	private String getResultString() {
		if (ball == 0 && strikes == 0) {
			return "낫싱";
		}
		
		if (ball == 0 && strikes != 0)  {
			return  strikes + "스트라이크";
		}
		
		if (ball != 0 && strikes == 0)  {
			return ball + "볼";
		}
			
		
		return ball + "볼 " + strikes + "스트라이크";
	}
		
		
		}
