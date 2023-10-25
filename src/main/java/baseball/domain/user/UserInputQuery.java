package baseball.domain.user;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import baseball.domain.computer.Computer;

public class UserInputQuery {

	private final List<Integer> userNumbers;

	public UserInputQuery(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("빈 값 대신 세 자리의 숫자를 넣어주세요.");
		}
		numbers = numbers.trim();
		if (numbers.length() > 3) {
			throw new IllegalArgumentException("세 자리 이상의 수는 넣을 수 없습니다.");
		}
		this.userNumbers = numbers.chars()
			.peek(e -> {
				if (!Character.isDigit(e)) {
					throw new IllegalArgumentException("입력 값이 잘못 되었습니다.");
				}
			})
			.filter(Character::isDigit)
			.mapToObj(Character::getNumericValue)
			.toList();
	}

	public User toDomain(final Computer computer) {
		return new User(computer, this.userNumbers);
	}
}
