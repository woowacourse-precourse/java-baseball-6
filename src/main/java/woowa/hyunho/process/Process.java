package woowa.hyunho.process;

import java.util.List;
import woowa.hyunho.game.End;
import woowa.hyunho.game.Game;
import woowa.hyunho.number.Computer;

public class Process {
	static final int RESTART = 1;
	static final int GAMEOVER = 2;
	List<Integer> computerRandomNumber;
	Game game;
	End end;
	
	public void start( ) {
		setGame();
		startGame();
		endGame();
	}
	
	private void setGame() {
		game = new Game();
		end = new End();
		Computer computer = new Computer();
		computerRandomNumber = computer.generateRandomNumber();
	}
	
	private void startGame() {
		game.startBaseball(computerRandomNumber);
	}
	
	private void endGame() {
		int selector = end.endProcess();
		checkSelector(selector);
	}
	
	private void checkSelector(int selector) {
		if (selector==RESTART) {
			restartGame();
		}
	}
	
	private void restartGame() {
		start();
	}
}