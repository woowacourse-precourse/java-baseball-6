package baseball;

public class GameController {

	private Computer computer;
	private Player player;
	
	public void play() {
		setComputerNumber(); // 컴퓨터 랜덤 숫자 생성
		setPlayerNumber(); // 플레이어 숫자 입력
	}

	public void setComputerNumber() {
		computer = new Computer();
		computer.setComputerNumber();
	}
	public void setPlayerNumber() {
		player = new Player();
		player.setPlayerNumber(); //Input을 통해 String 인자 전달 필요	
	}	
}

