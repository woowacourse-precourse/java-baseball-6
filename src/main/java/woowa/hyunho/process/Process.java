package woowa.hyunho.process;

import woowa.hyunho.game.End;
import woowa.hyunho.game.Game;
import woowa.hyunho.number.Computer;

public class Process {
	static final int RESTART = 1;
	Computer computer = new Computer();
	Game game = new Game();
	End end = new End();
	
	public void start( ) {
		setGame();
		startGame();
		endGame();
	}
	
	private void setGame() {
		computer.generateRandomNumber();
	}
	
	private void startGame() {
		game.startBaseball(computer);
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
		this.computer = new Computer();
		this.game = new Game();
		this.end = new End();
		start();
	}
}