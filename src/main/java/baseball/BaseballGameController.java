package baseball;

// Controller: 사용자의 입력을 처리하고 모델과 뷰를 연결
public class BaseballGameController {
	private BaseballGameModel model;
	private BaseballGameView view;

	public BaseballGameController(BaseballGameModel model, BaseballGameView view) {
		this.model = model;
		this.view = view;
	}

	public void playGame() {
		view.displayMessage("숫자 야구 게임을 시작합니다.\n");

		while (true) {
			model.createNumber();
			// 테스트 System.out.print(model.answerNumberList);
			while (true) {
				int[] guessNumberList = view.getGuessFromUser();
				String result = model.compareNumber(guessNumberList);
				view.displayMessage(result);
				System.out.println();

				if (result.equals("3스트라이크")) {
					view.displayMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
					break;
				}
			}

			int choice = view.getNewGameChoice();
			if (choice != 1) {
				view.displayMessage("게임을 종료합니다.");
				break;
			}
		}
	}
}
