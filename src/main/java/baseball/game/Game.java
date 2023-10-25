package baseball.game;

import java.util.ArrayList;
import java.util.List;

import baseball.judge.Judge;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	private Judge judge;
	private List<Integer> computer;
	private Player player;
	private boolean gameOn;

	public Game() {
		this.judge = new Judge();
		this.computer = new ArrayList<>();
		this.player = new Player();
		this.gameOn = true;
	}

	public void init() {
		computer.clear();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		this.judge.setNumbers(this.computer);
	}

	public void start() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		while (this.gameOn == true) {
			init();
			while (this.judge.callPitch() == true) {
				System.out.print("숫자를 입력해주세요 : ");
				this.player.input();
				ArrayList<Integer> pitchBall = this.player.pitch();
				this.judge.judgePitch(pitchBall);
				this.judge.callSignal();
			}
			this.gameOn = askGame();
		}
	}

	public boolean askGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		//user input 1 or 2
		String input = Console.readLine();
		if (input.length() == 1 && input.charAt(0) - '0' == 2)
			return (false);
		return (true);
	}
}
