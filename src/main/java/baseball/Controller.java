package baseball;

import static baseball.utils.NumberUtils.getDigit;
import static baseball.utils.NumberUtils.parseInt;
import static baseball.utils.Validator.validateEndInput;
import static baseball.utils.Validator.validateInput;

import java.util.List;

public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {

        view.displayMessage(MessageType.START);

        List<Integer> computerNumber = model.generateRandomNumber();
//        // log
//        System.out.println("컴퓨터: " + computerNumber);

        while (!model.isGameEnded()) {

            view.displayMessage(MessageType.ASK_FOR_NUMBER);

            List<Integer> playerNumber = inputNumber();
//            // log
//            System.out.println("플레이어: " + playerNumber);

            GameResult result = model.calculateScore(computerNumber, playerNumber);

            view.displayScore(result);
            model.setGameEnded(result.isGameEnded());
        }

        askForRestart();
    }

    private void askForRestart() {
        view.displayMessage(MessageType.ASK_FOR_RESTART);
        String endInput = inputEndNumber();

        if (endInput.equals(MessageType.RESTART.getMessage())) {
            model.setGameEnded(false);
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

