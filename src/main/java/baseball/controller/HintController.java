package baseball.controller;

import java.util.List;

public class HintController {
	
	private int NUMBER_MAX = 3;
	private String IS_NOTHING_MESSAGE = "낫싱";
	private String BALL = "볼";
	private String STRIKE = "스트라이크";
	private String NULL_MESSAGE = "";
	
	public String hintMessage(List<Integer>computerNumber, List<Integer>userNumber) {
		
		String message = "";
		
		if(isNothing(computerNumber, userNumber)) {
			return isNothingMessage();
		}
		
		message += ballMessage(computerNumber, userNumber);
		message += strikeMessage(computerNumber, userNumber);
		
		return message;
	}
	
	private boolean isNothing(List<Integer>computerNumber, List<Integer>userNumber) {
		for(int i = 0; i < NUMBER_MAX; i++) {
			if(containNumber(computerNumber, userNumber.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	private String isNothingMessage() {
		return IS_NOTHING_MESSAGE;
	}
	private int ballNumber(List<Integer>computerNumber, List<Integer>userNumber) {
		int ball = 0;
		
		for(int i = 0;i<NUMBER_MAX;i++) {
			if(containNumber(computerNumber, userNumber.get(i))
					&&isDifferentNumber(computerNumber.get(i),userNumber.get(i))) {
				ball++;
			}
		}
		return ball;
	}
	private String ballMessage(List<Integer>computerNumber, List<Integer>userNumber) {
		int ball = ballNumber(computerNumber, userNumber);
		if(ball == 0) {
			return NULL_MESSAGE;
		}
		return ball+BALL+" ";
	}
	private int strikeNumber(List<Integer>computerNumber, List<Integer>userNumber) {
		int strike = 0;
		for(int i = 0;i<NUMBER_MAX;i++) {
			if(!isDifferentNumber(computerNumber.get(i),userNumber.get(i))) {
				strike++;
			}
		}
		return strike;
	}
	private String strikeMessage(List<Integer>computerNumber, List<Integer>userNumber) {
		int strike = strikeNumber(computerNumber,userNumber);
		if(strike==0)
			return NULL_MESSAGE;
		return strike+STRIKE;
	}
	
	private boolean containNumber(List<Integer>computerNumber, int userNum) {
		return computerNumber.contains(userNum);
	}
	private boolean isDifferentNumber(int computerNum, int userNum) {
		return computerNum!=userNum;
	}
}
