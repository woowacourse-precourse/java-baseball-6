package woowa.hyunho.utilities;

import java.util.List;
import java.util.ArrayList;

public class Compare {
	public static List<Integer> countStrikeAndBall(List<Integer> computerNumberList, List<Integer> userNumberList) {
		int i =0;
		List<Integer> strikeAndBall = new ArrayList<>();
		int strike = 0;
		int ball = 0;
		while (i < computerNumberList.size()) {
			strike += checkStrike(computerNumberList.get(i), userNumberList.get(i));
			ball += checkBall(computerNumberList, userNumberList.get(i));
			i++;
		}
		ball = ball - strike;
		strikeAndBall.add(strike);
		strikeAndBall.add(ball);
		return strikeAndBall;
	}
	
	private static int checkStrike(int computerNumber, int userNumber) {
		if (computerNumber == userNumber) return 1;
		return 0;
	}
	
	private static int checkBall(List<Integer> computerNumberList, int userNumber) {
		if (computerNumberList.contains(userNumber)) return 1;
		return 0;
	}
	
	public static boolean compareInt(int a, int b) {
		int result = Integer.compare(a, b);
		if (result==0) {
			return true;
		}
		return false;
	}
}