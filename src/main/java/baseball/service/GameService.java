package baseball.service;

import static baseball.domain.enums.Constants.END;
import static baseball.domain.enums.Constants.NUM_END;
import static baseball.domain.enums.Constants.NUM_SIZE;
import static baseball.domain.enums.Constants.NUM_START;
import static baseball.domain.enums.Constants.RETRY;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.util.Message;
import baseball.util.exception.invalidInputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private Game game;
    private User user = new User();
    private List<Integer> computer = new ArrayList<>();
    private Message message = new Message();

    record BaseballScore(int strikeCount, int ballCount) {
    }

    public void setGame() {
        game = new Game(NUM_SIZE.getValue(), NUM_START.getValue(), NUM_END.getValue());
        computer = game.getComputer();
    }

    public void startGame() {

        message.printStartMsg();
        int strikeCount = 0;

        while (strikeCount != NUM_SIZE.getValue()) {
            String userNum = Console.readLine();
            message.printInputMsg(userNum);

            BaseballScore score = checkCount(user.parseUserNum(userNum, NUM_SIZE.getValue()));
            message.printScore(score.strikeCount, score.ballCount);
            strikeCount = score.strikeCount;
        }
    }

    public void stopGame() {
        message.printEndMsg();
    }

    public boolean retryGame() {
        int answer = Integer.parseInt(Console.readLine());
        message.printRetryMsg(answer);

        if (answer == RETRY.getValue()) {
            return true;
        }

        if (answer == END.getValue()) {
            return false;
        }

        throw new invalidInputException();
    }

    private BaseballScore checkCount(int[] user) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < user.length; i++) {
            if (!computer.contains(user[i])) {
                continue;
            }
            if (computer.indexOf(user[i]) == i) {
                strikeCount++;
            } else {
                ballCount++;
            }
        }

        return new BaseballScore(strikeCount, ballCount);
    }

}
