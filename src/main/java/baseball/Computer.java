package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

//서로다른 3개의 수를 선택해 컴퓨터 리스트로 입력
public class Computer {
	public List<Integer> ComputerNumber(){
		List<Integer> computerNumber = new ArrayList<>();
		while (computerNumber.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerNumber.contains(randomNumber)) {
				computerNumber.add(randomNumber);
			}
		}
		return computerNumber;
	}
	
}
