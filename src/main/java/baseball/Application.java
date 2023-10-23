package baseball;

public class Application {
	public static void main(String[] args) {
		BaseballView baseballView = new BaseballView();
		BaseballComputer baseballComputer = new BaseballComputer();
		BaseballUmpire baseballUmpire = new BaseballUmpire();
		BaseballGame baseballGame = new BaseballGame(
			baseballView, baseballComputer, baseballUmpire
		);

		// 게임 시작
		baseballView.printGameStart();
		baseballGame.startBaseballGame();
	}
}
