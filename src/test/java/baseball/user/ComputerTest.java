package baseball.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	@Test
	@DisplayName("컴퓨터는 임의의 숫자 3개를 생성 할 수 있다.")
	public void settingNumberTest() {
		//given
		Computer computer = new Computer();
		computer.settingNumbers();

		//when
		List<String> computerNumbers = computer.getComputerNumbers();

		// then
		assertEquals(3, computerNumbers.size());
	}

	@Test
	@DisplayName("사용자의 입력값의 따라 결과가 달라진다.")
	public void inspectNumberTest() {
		Computer computer = new Computer();
		computer.settingNumbers();
		List<String> computerNumbers = computer.getComputerNumbers();
		String[] numbersArray = computerNumbers.toArray(new String[0]);
		String input = String.join("", numbersArray);


		int[] result = computer.inspectNumber(input);
		assertEquals(3, result[0]);
		assertEquals(0, result[1]);


		String modifiedInput = numbersArray[0] + numbersArray[2] + numbersArray[1];
		result = computer.inspectNumber(modifiedInput);
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
	}
}
