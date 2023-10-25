package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}

class GameController {
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

    private void checkLength(String String) {
        if (String.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInt(String String) {
        try {
            int inputInt = Integer.parseInt(String);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String String) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < String.length(); i++) {
            char currentChar = String.charAt(i);
            if (charSet.contains(currentChar)) {
                throw new IllegalArgumentException();
            }
            charSet.add(currentChar);
        }
    }

    private List<Integer> stringToIntList(String String) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < String.length(); i++) {
            char digitChar = String.charAt(i);
            int digitInt = Character.getNumericValue(digitChar);
            intList.add(digitInt);
        }
        return intList;
    }
}

class GameView {
    private final static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_NUMBERS = "숫자를 입력해주세요 : ";
    private final static String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String INPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void showGameStart() {
        System.out.println(GAME_START);
    }

    public void showInputNumbers() {
        System.out.print(INPUT_NUMBERS);
    }

    public void showGameEnd() {
        System.out.println(GAME_END);
    }

    public void showInputRestart() {
        System.out.println(INPUT_RESTART);
    }

    public void showString(String string) {
        System.out.println(string);
    }

    public String getInput() {
        return Console.readLine();
    }
}

class Game {
    private final int NUMBER_LENGTH = 3;
    private final List<Integer> answerNumbers = new ArrayList<>();
    private final boolean PLAYING = true;
    private final boolean END = false;
    private boolean gameStatus;
    private final String RESTART = "1";
    private final String QUIT = "2";

    Game() {
        this.setAnswerNumbers();
        this.gameStatus = PLAYING;
    }

    private void setAnswerNumbers() {
        while (this.answerNumbers.size() < this.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answerNumbers.contains(randomNumber)) {
                this.answerNumbers.add(randomNumber);
            }
        }
    }

    public String makeGameResult(List<Integer> inputNumbers) {
        GameResult gameResult = new GameResult(this.answerNumbers, inputNumbers);
        applyResult(gameResult.getStrikes());
        return gameResult.resultToString();
    }

    public void applyResult(int strikes) {
        if (strikes == NUMBER_LENGTH) {
            this.gameStatus = END;
        }
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public boolean isRestart(String input) {
        if (input.equals(RESTART)) {
            return true;
        } else if (input.equals(QUIT)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

class GameResult {
    private int balls = 0;
    private int strikes = 0;

    GameResult(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        for (int i = 0; i < answerNumbers.size(); i++) {
            int answerDigit = answerNumbers.get(i);
            int inputDigit = inputNumbers.get(i);

            if (answerDigit == inputDigit) {
                this.strikes++;
            } else if (answerNumbers.contains(inputDigit)) {
                this.balls++;
            }
        }
    }

    public String resultToString() {
        String result = "";
        if (this.balls != 0) {
            result += this.balls + "볼";
        }
        if (this.strikes != 0) {
            if (this.balls != 0) {
                result += " ";
            }
            result += this.strikes + "스트라이크";
        }
        if (this.balls == 0 && this.strikes == 0) {
            result = "낫싱";
        }
        return result;
    }

    public int getStrikes() {
        return this.strikes;
    }

}