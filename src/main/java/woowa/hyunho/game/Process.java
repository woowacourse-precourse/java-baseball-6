package woowa.hyunho.game;

import woowa.hyunho.number.Computer;
import woowa.hyunho.messages.Messages;
import woowa.hyunho.process.Game;
import woowa.hyunho.process.End;

public class Process {
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
		if (selector==1) {
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