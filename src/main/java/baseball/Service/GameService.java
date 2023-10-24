package baseball.Service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.CompareUtils;
import baseball.utils.ParseUserInput;
import baseball.utils.RandomUtils;
import baseball.view.PrintGameResult;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int size;

    User user = new User();
    Game game = new Game();
    ParseUserInput parseUserInput = new ParseUserInput();
    RandomUtils randomUtils = new RandomUtils();
    SystemMessage systemMessage = new SystemMessage();

    CompareUtils compareUtils = new CompareUtils();

    public void playGame(int size, int startInclusive, int endInclusive) {
        int strike = 0;
        systemMessage.printGameStart();
        while (strike != 3) {
            play();
            printGameResult(game.getStrike(), game.getBall());
            strike = game.getStrike();
        }
    }

    private void play() {
        game.intiField();
        user.setUserNums(requestUserNumbers());
        compare(game.getResult_arr(), user.getUserNums(), game);
    }


    public void setGame(int size, int startInclusive, int endInclusive) {
        this.size = size;
        game.setResult_arr(getRandomNumbers(size, startInclusive, endInclusive));
    }

    private int[] getRandomNumbers(int size, int startInclusive, int endInclusive) {
        return randomUtils.getRandomNumbers(size, startInclusive, endInclusive);
    }

    public int[] requestUserNumbers() {
        systemMessage.requestNum();
        String input = Console.readLine();
        return parseUserInput.getUserNumbers(input, size);
    }


    private void compare(int[] gameNumber, int[] userNumber, Game game) {
        for (int i = 0; i < gameNumber.length; i++) {
            for (int j = 0; j < userNumber.length; j++) {
                compareUtils.validateResult(gameNumber, userNumber, i, j, game);
            }
        }
    }

    public int requestRetry() {
        systemMessage.requestRetryMessage();
        int retry = Integer.parseInt(Console.readLine());
        return retry;
    }

    private void printGameResult(int strike, int ball) {
        PrintGameResult printGameResult = new PrintGameResult();
        printGameResult.printGameResult(strike, ball);
        checkGameOver(strike);
    }

    private void checkGameOver(int strike) {
        if (strike == 3) {
            systemMessage.printGameOver();
        }
    }
}
