package baseball;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
	public static List<Integer> convert(String input, int length) throws IllegalArgumentException {
		// 최종 결과를 담을 List 생성
		List<Integer> candidate = new ArrayList<>();

		// 입력 문자열 길이 검증
		if (input.length() != length) {
			throw new IllegalArgumentException();
		}

		// 입력 문자열이 모두 숫자로 변환 가능한지 체크(음수, 소수, 문자는 변환 불가)
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				candidate.add(Character.getNumericValue(c));
			} else {
				throw new IllegalArgumentException();
			}
		}

		// 입력에 중복이 있는지 확인
		if ((candidate.stream().distinct().count()) != length) {
			throw new IllegalArgumentException();
		}

		// 입력 중 0이 있나 확인
		if (candidate.contains(0)) {
			throw new IllegalArgumentException();
		}

		return candidate;
	}
}
