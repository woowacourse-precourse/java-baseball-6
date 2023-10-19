package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	public static void printResult(List<Integer> result) {
		List<String> resultMessage = new ArrayList<>();
		if (result.get(0) == 0 && result.get(1) == 0) {
			System.out.println("낫싱");
			return;
		}
		if (result.get(0) > 0) {
			resultMessage.add(result.get(0) + "볼");
		}
		if (result.get(1) > 0) {
			resultMessage.add(result.get(1) + "스트라이크");
		}
		System.out.println(String.join(" ", resultMessage));
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
