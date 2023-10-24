package baseball;

import java.util.List;

public class IllegalDetector {
	public void InitialInputLengthDetector(String UserInput) {
		if(UserInput.length()>3) {
			throw new IllegalArgumentException("3글자를 입력하시오.");
		}
	}
	public void RedundantDetector(List<Integer> UserNums) {
        if(UserNums.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("서로 다른 3글자를 입력하시오.");
        }
    }
	
	public void InputRangeDetector(List<Integer> UserNums) {
		if(!UserNums.stream().allMatch(num -> 1<=num && 9 >= num)) {
			throw new IllegalArgumentException("1~9 사이 숫자를 입력하시오.");
		}
	}
	
	public void GameplayDetector(String Gameplay) {
		if(!Gameplay.equals("1")&&!Gameplay.equals("2")) {
			throw new IllegalArgumentException("1:게임 재시작, 2:게임 종료 중 입력하십시오");
		}
	}
}
