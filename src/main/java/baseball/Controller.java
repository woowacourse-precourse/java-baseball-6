package baseball;

import static baseball.utils.NumberUtils.getDigit;
import static baseball.utils.NumberUtils.parseInt;
import static baseball.utils.Validator.validateEndInput;
import static baseball.utils.Validator.validateInput;

import baseball.entity.GameResult;
import baseball.enums.MessageType;
import java.util.List;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {

        view.displayMessage(MessageType.START);

        GameResult gameResult = model.gameResult;

        List<Integer> computerNumber = model.generateRandomNumber();
        // log
        System.out.println("컴퓨터: " + computerNumber);

        while (!gameResult.isGameEnded()) {

            view.displayMessage(MessageType.ASK_FOR_NUMBER);

            List<Integer> playerNumber = inputNumber();

            gameResult = model.calculateScore(computerNumber, playerNumber);

            view.displayScore(gameResult);

            gameResult.resetScore();
        }

        askForRestart(gameResult);
    }

    private void askForRestart(GameResult gameResult) {

        view.displayMessage(MessageType.ASK_FOR_RESTART);

        String endInput = inputEndNumber();

        if (endInput.equals(MessageType.RESTART.getMessage())) {
            gameResult.setGameRestart();
            startGame();
        } else if (endInput.equals(MessageType.FINISH.getMessage())) {
            view.displayMessage(MessageType.GAME_ENDED);
        }
    }

    /**
     * 사용자의 입력을 list<integer>로 변환하는 메서드
     */
    public List<Integer> inputNumber() {

        String input = view.readInput();
        validateInput(input);
        int number = parseInt(input);

        return getDigit(number);
    }

    /**
     * 사용자의 입력을 검증 후 String으로 반환하는 메서드
     */
    public String inputEndNumber() {

        String endInput = view.readInput();
        validateEndInput(endInput);

        return endInput;
    }
}

