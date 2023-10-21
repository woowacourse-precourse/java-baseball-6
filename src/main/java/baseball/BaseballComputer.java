package baseball;

import java.util.HashSet;
import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Randoms;

/* 1에서 9까지 서로 다른 임의의 수 3개의 숫자 생성 */
public class BaseballComputer {
	// HashSet<Integer> 타입을 String 타입으로 변환 (숫자 게임에 사용)
	public String createComputerNumbers() {
		HashSet<Integer> computerNumbers = pickComputerNumbers();
		StringBuilder str = new StringBuilder();
		for (Integer computerNumber : computerNumbers) {
			str.append(computerNumber);
		}
		return str.toString();
	}

	// 랜덤으로 1~9 사이의 임의의 숫자 생성 (중복 x)
	private HashSet<Integer> pickComputerNumbers() {
		HashSet<Integer> computerNumbers = new LinkedHashSet<>(); // 중복 방지용 hashset
		while (computerNumbers.size() < 3) {
			computerNumbers.add(Randoms.pickNumberInRange(1, 9));
		}
		return computerNumbers;
	}
}