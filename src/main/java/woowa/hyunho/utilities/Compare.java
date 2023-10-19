package woowa.hyunho.utilities;

import java.util.List;

public class Compare {
	public static int checkStrike(List<Integer> computer, List<Integer> user) {
		int i = 0;
		int strike = 0;
		while (i < computer.size()) {
			if (computer.get(i)==user.get(i)) 
					strike++; 
			i++;
		}
		return strike;
	}
	
	public static int checkBall(List<Integer> computer, List<Integer> user) {
		int i = 0;
		int ball = 0;
		while (i < computer.size()) {
			if (computer.contains(user.get(i))) 
					ball++; 
			i++;
		}
		return ball;
	}
}