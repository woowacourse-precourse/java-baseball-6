package baseball.service;

import baseball.domain.Baseball;
import baseball.utils.MessageUtils;
import baseball.utils.RandomUtils;

import java.util.List;
import java.util.Objects;

public class BaseballGameService {
    final int RETRY_NUMBER = 1;
    final int GAME_END_NUMBER = 2;
    final int GAME_SIZE = 3;
    final int ASK_RETRY_SIZE = 1;
    MessageUtils messageUtils = new MessageUtils();
    RandomUtils randomUtils = new RandomUtils();
    UserInputService userInputService = new UserInputService();

    public void setGame() {
        messageUtils.startGameMessage();
        List<Integer> randomNumbers
                = randomUtils.getRandomNumbers(GAME_SIZE);

        playGame(randomNumbers);
    }

    public void playGame(List<Integer> randomNumbers) {
        boolean game = true;
        while (game) {
            messageUtils.inputUserNumberMessage();

            List<Integer> userInputNumbers
                    = userInputService.userInput(GAME_SIZE);

            Baseball gameCnt
                    = getGameCnt(randomNumbers, userInputNumbers);

            messageUtils.ballStrikeMessage(gameCnt.getBall(), gameCnt.getStrike());

            if (gameCnt.getStrike() == GAME_SIZE) {
                game = askRetryGame();
            }
        }
    }

    public boolean askRetryGame() {
        messageUtils.retryGameMessage();

        List<Integer> userInput
                = userInputService.userInput(ASK_RETRY_SIZE);

        if (userInput.contains(RETRY_NUMBER)) {
            setGame();
        } else if (!userInput.contains(GAME_END_NUMBER)) {
            throw new IllegalArgumentException();
        }

        return false;
    }

    private Baseball getGameCnt(List<Integer> randomNumbers, List<Integer> userInputNumbers) {
        Baseball baseball = new Baseball();
        baseball.initGame();

        for (Integer randomNumber : randomNumbers) {
            for (Integer userInputNumber : userInputNumbers) {
                if (Objects.equals(randomNumber, userInputNumber)) {
                    if (randomNumbers.indexOf(randomNumber) == userInputNumbers.indexOf(userInputNumber)) {
                        baseball.strikeCntUp();
                    } else {
                        baseball.ballCntUp();
                    }
                }
            }
        }

        return baseball;
    }
}
