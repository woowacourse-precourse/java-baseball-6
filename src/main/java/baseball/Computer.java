package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> numberList = new ArrayList<>();   // 컴퓨터가 생성한 숫자(난수) 리스트

	/**
	 * 1~9 사이의 서로 다른 숫자 3개를 생성하여 리스트에 저장하는 메서드
	 */
	public void init() {
		numberList.clear();
		while (numberList.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!numberList.contains(randomNumber)) {
				numberList.add(randomNumber);
			}
		}
	}

	/**
	 * 컴퓨터가 생성한 숫자 리스트 반환을 위한 getter 메서드
	 * @return 컴퓨터가 생성한 숫자 리스트
	 */
	public List<Integer> getNumberList() {
		return numberList;
	}
}
