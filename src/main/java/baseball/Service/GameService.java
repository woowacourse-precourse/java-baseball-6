package baseball.Service;

import baseball.domain.Game;
import baseball.domain.User;
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

    private void play() {
        game.intiField();
        user.setUserNums(requestUserNumbers());
        compare(game.getResult_arr(), user.getUserNums());
    }

    public void playGame(int size, int startInclusive, int endInclusive) {
        int strike = 0;
        systemMessage.printGameStart();
        setGame(size, startInclusive, endInclusive);
        while (true) {
            play();
            printGameResult(game.getStrike(), game.getBall());
        }
    }

    public void setGame(int size, int startInclusive, int endInclusive) {
        this.size = size;
        game.intiField();
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


    private void compare(int[] gameNumber, int[] userNumber) {
        for (int i = 0; i < gameNumber.length; i++) {
            for (int j = 0; j < userNumber.length; j++) {
                if (gameNumber[i] == userNumber[j] && i == j) {
                    game.strikeCount();
                }
                if (gameNumber[i] == userNumber[j] && i != j) {
                    game.ballCount();
                }
            }
        }
    }

    public int requestRetry() {
        int retry = Integer.parseInt(Console.readLine());
        return retry;
    }

    private boolean printGameResult(int strike, int ball) {
        PrintGameResult printGameResult = new PrintGameResult();
        printGameResult.printGameResult(strike, ball);
        if (strike == 3) {
            systemMessage.printGameOver();
            return false;
        }
        return true;
    }
}
