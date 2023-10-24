package baseball;

import java.util.List;

public class IllegalDetector {
	public void InitialInputLengthDetector(String UserInput) {//3글자 초과시 예외처리
		if(UserInput.length()>3) {
			throw new IllegalArgumentException("3글자를 입력하시오.");
		}
	}
	public void RedundantDetector(List<Integer> UserNums) {//중복된 숫자가 있을 시 예외처리
        if(UserNums.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("서로 다른 3글자를 입력하시오.");
        }
    }
	
	public void InputRangeDetector(List<Integer> UserNums) {// 1~9사이 숫자를 입력하지 않을 시 예외처리
		if(!UserNums.stream().allMatch(num -> 1<=num && 9 >= num)) {
			throw new IllegalArgumentException("1~9 사이 숫자를 입력하시오.");
		}
	}
	
	public void GameplayDetector(String Gameplay) {// 게임 종료 후 1 또는 2를 입력하지 않으면 예외처리
		if(!Gameplay.equals("1")&&!Gameplay.equals("2")) {
			throw new IllegalArgumentException("1:게임 재시작, 2:게임 종료 중 입력하십시오");
		}
	}
}
