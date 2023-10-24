package baseball;

public class GameController {

	private NumberCompare numberComp;
	private Computer computer;
	private Player player;

	public void play() {
		setComputerNumber(); // 컴퓨터 랜덤 숫자 생성

		do {
			setPlayerNumber(); // 플레이어 숫자 입력
			compareNumber(); // 컴퓨터, 플레이어 숫자 비교
			Output.displayGameResult(numberComp.getStrike(), numberComp.getBall()); // 게임 결과 출력
		} while (numberComp.isThreeStrikes());
	}

	public void setComputerNumber() {
		computer = new Computer();
		computer.setNumber();
	}

	public void setPlayerNumber() {
		player = new Player();
		player.setNumber(Input.getPlayerNumber());
	}

	public void compareNumber() {
		numberComp = new NumberCompare();
		numberComp.compare(computer.getNumber(), player.getNumber());
	}
}

