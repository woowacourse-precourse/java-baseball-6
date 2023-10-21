package baseball.Controller;

import baseball.Model.BaseBallGame;
import baseball.Model.NumberGenerator;
import baseball.View.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    NumberGenerator numberGenerator = new NumberGenerator();
    BaseBallGame baseBallGame = new BaseBallGame(numberGenerator);
    GameView gameView = new GameView();

    public GameController() {

    }

    public void startGame() {
        gameView.printStartMessage();
        while (true) {
            String input = gameView.printInputMessage();
            List<Integer> userInput = parseUserInput(input);

            baseBallGame.playingGame(userInput);

            gameView.printGameOverMessage();
        }
    }

    /**
     * 유저값 파싱해줌 뭔가 이건 Model에 있어야할것 같은데.
     */
    private List<Integer> parseUserInput(String input) {
        List<Integer> parsedInput = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 자릿 수 오류");
        }

        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                parsedInput.add(digit);
            } else {
                throw new IllegalArgumentException("입력 자릿 수 오류");
            }
        }

        return parsedInput;
    }
}
