package baseball.player;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private String input;

	public void input() {
		this.input = Console.readLine();
	}

	public ArrayList<Integer> pitch() {
		ArrayList<Integer> pitchBall = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			int num = input.charAt(i) - '0';
			pitchBall.add(num);
		}
		return (pitchBall);
	}
}
