package baseball.Controller;

import baseball.Model.Game;
import baseball.View.GameView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameController {
    private final GameView gameView = new GameView();

    GameController() {
        gameView.showGameStart();
    }

    public void start() {
        Game game = new Game();
        while (game.getGameStatus()) {
            gameView.showInputNumbers();
            String strInputNumbers = gameView.getInput();
            validInputNumbers(strInputNumbers);
            List<Integer> inputNumbers = stringToIntList(strInputNumbers);

            String gameResult = game.makeGameResult(inputNumbers);
            gameView.showString(gameResult);
        }
        gameView.showGameEnd();

        gameView.showInputRestart();
        String strInputRestart = gameView.getInput();
        if (game.isRestart(strInputRestart)) {
            start();
        }
    }

    private void validInputNumbers(String String) {
        checkLength(String);
        checkInt(String);
        checkDuplicate(String);
    }

    private void checkLength(String String) { //입력값이 길이가 3인지 확인
        if (String.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInt(String String) { //입력 값이 정수형인지 확인
        try {
            int inputInt = Integer.parseInt(String);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String String) { //입력값이 같은지 판단 ex)333 221 112
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < String.length(); i++) {
            char currentChar = String.charAt(i);
            if (charSet.contains(currentChar)) {
                throw new IllegalArgumentException();
            }
            charSet.add(currentChar);
        }
    }

    private List<Integer> stringToIntList(String String) { //입력값을 List로 변경
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < String.length(); i++) {
            char digitChar = String.charAt(i);
            int digitInt = Character.getNumericValue(digitChar);
            intList.add(digitInt);
        }
        return intList;
    }
}