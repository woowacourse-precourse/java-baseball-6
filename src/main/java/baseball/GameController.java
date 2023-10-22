package baseball;

public class GameController {

	private CompareNumber compare;
	private Computer computer;
	private Player player;
	
	public void play() {
		setComputerNumber(); // 컴퓨터 랜덤 숫자 생성
		setPlayerNumber(); // 플레이어 숫자 입력
		compareNumber(); // 컴퓨터, 플레이어 숫자 비교
	}

	public void setComputerNumber() {
		computer = new Computer();
		computer.setComputerNumber();
	}
	
	public void setPlayerNumber() {
		player = new Player();
		player.setPlayerNumber(Input.inputPlayerNumber());
	}	


	public void compareNumber() {
		compare = new CompareNumber();
		compare.compare(computer.computerNumber, player.playerNumber);
	}
}

