package baseballgame;

import java.util.List;

public class BaseballResultCalculator {
	int strikes = 0;
	int ball = 0;
	
	
	public int getBall() {
		return ball;
		
	}
	
	public int getStrike() {
		return strikes;
	}

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
		
		private String getResultString() {
			
		if (ball == 0 && strikes == 0) return "낫싱";
		
		if (ball == 0 && strikes != 0)   return  strikes + "스트라이크";
		
		if (ball != 0 && strikes == 0)   return ball + "볼";
			
		
		return ball + "볼 " + strikes + "스트라이크";
	}
		
		
		}
