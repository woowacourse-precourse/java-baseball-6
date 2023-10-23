package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {
	
	/* 유저로부터 입력값 받는 메소드 */
	public List<Integer> input() {
		
		List<Integer> inputData = new ArrayList<Integer>();
		
		System.out.print("숫자를 입력해주세요 : ");
		String userPick = Console.readLine();
		
		if (userPick.length() != 3) throw new IllegalArgumentException("세 자리 숫자를 입력해 주세요.");
		
		for (char nxtPick : userPick.toCharArray()) {
			
			if (!Character.isDigit(nxtPick)) throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
			
			int cvt = nxtPick - '0'; // char -> int 변환
			
			if (inputData.contains(cvt)) throw new IllegalArgumentException("동일한 숫자는 입력할 수 없습니다.");
			
			if (cvt == 0) throw new IllegalArgumentException("0은 숫자 야구 게임이 포함되지 않습니다.");
			
			inputData.add(cvt);
		}

		return inputData;
	}
}