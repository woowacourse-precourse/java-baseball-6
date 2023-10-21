package baseball;

import java.util.HashSet;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

/* 1에서 9까지 서로 다른 임의의 수 3개의 숫자 생성 */
public class BaseballComputer {
	// 컴퓨터 숫자 세자리 생성
	public String createComputerNumbers() {
		HashSet<Integer> computerNumbers = pickComputerNumbers();
		StringBuilder str = new StringBuilder();
		for (Integer computerNumber : computerNumbers) {
			str.append(computerNumber);
		}
		return str.toString();
	}

	// 랜덤으로 1~9까지의 숫자 생성
	private HashSet<Integer> pickComputerNumbers() {
		HashSet<Integer> computerNumbers = new LinkedHashSet<>(); // 중복 방지용 hashset
		while (computerNumbers.size() < 3) {
			computerNumbers.add(Randoms.pickNumberInRange(1, 9));
		}
		return computerNumbers;
	}
}