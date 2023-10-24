package baseball.service;

import baseball.config.Config;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.RandomUtils;
import baseball.view.ErrorView;
import baseball.view.PrintView;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private final Config config;
    private final int size;
    private final int minValue;
    private final int maxValue;
    Game game;
    User user;
    PrintView printView = new PrintView();
    ErrorView errorView = new ErrorView();

    public GameService(Config config) {
        this.config = config;
        this.size = config.getGameSize();
        this.minValue = config.getMinValue();
        this.maxValue = config.getMaxValue();
    }

    public void gameSet() {
        game = new Game(RandomUtils.getRandomNumbers(size,minValue,maxValue));
    }

    public void startGame() {
        printView.printGameStartMessage();
        while (game.getStrike()!=3) {
            game.initScore();
            setupUser();
            validateInputNumber(game.getAnswer(), user.getInputNum());
        }
        printView.printGameEndMessage();
    }
    public void setupUser() {
        user = new User(getInputNumber());
    }

    // 입력값을 받는다.
    public int[] getInputNumber() {
        printView.printUserInputMessage();
        int[] inputNum = new int[size];
        String input = Console.readLine();
        if (input.length() != size) {
            errorView.inputNumberLengthError();
        }

        return parseToIntString(input, inputNum);
    }

    public int[] parseToIntString(String input, int[] inputNum) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                errorView.validateInputError();
            }
            inputNum[i] = Integer.parseInt(String.valueOf(c));
        }
        return inputNum;
    }

    // 입력받은 숫자를 검증한다.
    public void validateInputNumber(int[] answer, int[] inputNum) {

        for (int i = 0; i < answer.length; i++) {
            compareNumber(answer, inputNum, i);
        }
        printView.printScoreMessage(game.getStrike(), game.getBall());
    }

    // 정답과 숫자가 같은지 확인한다.
    public void compareNumber(int[] answer, int[] inputNum, int index) {
        for (int j = 0; j < inputNum.length; j++) {
            if (answer[index] == inputNum[j]) {
                updateScore(index, j);
                break;
            }
        }
    }

    // 스트라이크와 볼의 갯수를 구한다.
    public void updateScore(int index, int j) {
        if (index != j) {
            game.increaseBall();
        }
        if (index == j) {
            game.increaseStrike();
        }
    }
}
