package baseball.player;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private String input;
	public static final int PITCH_NUM = 3;

	public void input() {
		this.input = Console.readLine();
		if (input.length() != 3) {
			throw new IllegalArgumentException("input 3 numbers between 1 ~ 9.");
		}
		for (int i = 0; i < PITCH_NUM; i++) {
			int number = Character.getNumericValue(input.charAt(i));
			if (number < 1 || number > 9) {
				throw new IllegalArgumentException("input 3 different numbers between 1 ~ 9.");
			}
			for (int j = 0; j < i; j++) {
				if (input.charAt(i) == input.charAt(j)) {
					throw new IllegalArgumentException("input 3 different numbers between 1 ~ 9.");
				}
			}
		}
	}

	public ArrayList<Integer> pitch() {
		ArrayList<Integer> pitchBall = new ArrayList<>();
		for (int i = 0; i < PITCH_NUM; i++) {
			int num = input.charAt(i) - '0';
			pitchBall.add(num);
		}
		return (pitchBall);
	}
}
