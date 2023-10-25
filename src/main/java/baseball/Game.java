package baseball;

public class Game {

	private Player computer;
	private Player user;
	private Referee referee;

	public Game() {
		this.referee = new Referee();
		OutputView.print(PrintMessage.START);
	}

	public void start() {
		init();
		progress();
		isEnd();
	}

	private void init(){
		computer = new Player(new RandomNumbersGenerator());
	}

	private void progress() {
		while (true) {
			OutputView.print(PrintMessage.REQUESTNUMBER);
			user = new Player(new InputNumbersGenerator());

			Result result = referee.compare(computer.read(), user.read());

			OutputView.print(result);

			if (result.isSize(ResultKind.STRIKE,3)) {
				return;
			}
		}
	}

	private void isEnd() {
		OutputView.print(PrintMessage.REQUEST_REPLY);

		if (Option.isEnd(InputView.selectDone())) {
			return;
		}
		start();
	}
}