package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

// 사용자에게 숫자 입력 받기 
public class UserAnswer {
	private List<Integer> userAnswer;
	
	public UserAnswer() {
		this.userAnswer = new ArrayList<>();
	}
	
	// 입력 중복 확인
	public boolean checkSameNum() {
		return (this.userAnswer.get(0) != userAnswer.get(1))
		        && (this.userAnswer.get(1) != userAnswer.get(2))
		        && (this.userAnswer.get(0) != userAnswer.get(2));
	}
	
	// 0이 있는지 확인
	public boolean isZero() {
		for(int i = 0; i < 3; i++) {
			if(this.userAnswer.get(i) == 0) return false;
		}
		return true;
	}
	
	// userAnswer 입력
	public void setUserAnswer() {
		System.out.print("숫자를 입력해주세요 : ");
		// 입력 
		String str = Console.readLine();
		String[] strArray = str.split("");
		
		if(strArray.length == 3) {
			for(int i = 0; i < 3; i ++) {
				try {
					int num = Integer.parseInt(strArray[i]);
					this.userAnswer.add(num);
				}
				// 유효하지 않은 숫자 
				catch(NumberFormatException  e) {
					throw new IllegalArgumentException();
				}
			}
		}
		
		// 유효하지 않은 자리수
		else {
			 throw new IllegalArgumentException();
		}
		
		// 서로 다른 숫자가 아닐 경우 && 0이 포함된 경우
		if(!(checkSameNum() && isZero())) throw new IllegalArgumentException();
	}
	
	public List<Integer> getUserAnswer() {
		return this.userAnswer;
	}
}
