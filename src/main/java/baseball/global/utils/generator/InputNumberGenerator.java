package baseball.global.utils.generator;

import baseball.domain.service.ClientService;
import java.util.ArrayList;
import java.util.List;

public class InputNumberGenerator implements NumberGenerator {

	@Override
	public List<Integer> generate() {
		String input = getInput();
		return initializeNumbers(input);
	}

	private List<Integer> initializeNumbers(String input) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			numbers.add(Character.getNumericValue(input.charAt(i)));
		}
		return numbers;
	}

	private String getInput() {
		ClientService clientService = new ClientService();
		return clientService.getCommonInput();
	}
}
