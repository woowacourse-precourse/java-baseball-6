package woowa.hyunho.utilities;

import java.util.ArrayList;
import java.util.List;

public class Compare {
	public static List<Integer> countResult(List<Integer> computer, List<Integer> user) {
		return countMatchingElements(computer, user);
	}
	
	private static List<Integer> countMatchingElements(List<Integer> computer, List<Integer> user) {
		int i =0;
		List<Integer> result = new ArrayList<>();
		int strike = 0;
		int ball = 0;
		while (i < computer.size()) {
			strike += checkStrike(computer.get(i), user.get(i));
			ball += checkBall(computer, user.get(i));
			i++;
		}
		ball = ball - strike;
		result.add(strike);
		result.add(ball);
		return result; 
	}
	
	private static int checkStrike(int computer, int user) {
		if (computer == user) return 1;
		return 0;
	}
	
	private static int checkBall(List<Integer> computer, int user) {
		if (computer.contains(user)) return 1;
		return 0;
	}
}