package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private InputView inputView;
    private OutputView outputView;
    private GameManager gameManager;

    public Game() {
        inputView = new InputView();
        gameManager = new GameManager();
    }

    public void gameStart() {
        inputView.printGameStartMessage();
        do {
            Problem problem = new Problem();
            gameManager.setAnswer(problem.getAnswer());
            do {
                inputInit();
                outputInit();
            } while (!gameManager.isGameOver());
        } while (selectRestartOrExit());
    }

    private void outputInit() {
        outputView = new OutputView(gameManager.getStrikeCount(), gameManager.getBallCount(), gameManager.isNothing());
        outputView.printResult();
    }

    private void inputInit() {
        inputView.printNumberMessage();
        String input = Console.readLine();
        InputValidate inputValidate = new InputValidate(input);
        inputValidate.validateInput();
        gameManager.setInputConvertList(input);
    }

    private boolean selectRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        gameManager.validateRestartOrExitWrongInput(input);
        if (gameManager.gameRestart(input)) {
            return true;
        } else if (gameManager.gameExit(input)) {
            return false;
        }
        return false;
    }


}
