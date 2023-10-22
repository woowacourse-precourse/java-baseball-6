package baseball;

public class GameController {

	private CompareNumber compare;
	private Computer computer;
	private Player player;
	
	public void play() {
		setComputerNumber(); // 컴퓨터 랜덤 숫자 생성
		
		do {
		setPlayerNumber(); // 플레이어 숫자 입력
		compareNumber(); // 컴퓨터, 플레이어 숫자 비교
		Output.gameResult(compare.getStrike(), compare.getBall()); // 게임 결과 출력
		} while (compare.threeStrike());
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
		compare.compare(computer.getComputerNumber(), player.getPlayerNumber());
	}
}

