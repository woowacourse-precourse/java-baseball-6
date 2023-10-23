package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballInformation {

	private String answerNumber;
	private int strikeCount;
	private int ballCount;
	private int numberCount = 3;


	public BaseballInformation(){
		initNumber();
	}

	//random 3자리 수 초기화
	private void initNumber(){
		answerNumber = "";
		while(answerNumber.length()<numberCount){
			String newDigit = Integer.toString(Randoms.pickNumberInRange(0, 9));
			if(answerNumber.contains(String.valueOf(newDigit))==false) {
				answerNumber += newDigit;
			}
		}
	}

	public void compareAndSetStrikeBallCount(String inputNumber){
		strikeCount = 0;
		ballCount = 0;
		for (int i = 0; i < answerNumber.length(); i++) {
			char answerDigit = answerNumber.charAt(i);
			char guessDigit = inputNumber.charAt(i);

			if (answerDigit == guessDigit) {
				strikeCount++;
			} else if (answerNumber.contains(String.valueOf(guessDigit))) {
				ballCount++;
			}
		}
	}


	public String getAnswerNumber() {
		return answerNumber;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
	public int getNumberCount() {
		return numberCount;
	}
}
