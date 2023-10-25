package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Util;
import baseball.utils.Validation;
import baseball.view.OutPut;
import baseball.view.UserInPut;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Service {
    Game game = new Game();
    User user = new User();
    Validation validation = new Validation();
    Util util = new Util();
    OutPut outPut = new OutPut();
    UserInPut userInPut = new UserInPut();

    static final int RANDOM_NUMBER_LENGTH = 3;
    static final int RANDOM_NUMBER_START = 1;
    static final int RANDOM_NUMBER_END = 9;

    public void setGame() {
        game.setCountZero();
        game.setRandomNumber(generateRandomNumbers(RANDOM_NUMBER_LENGTH, RANDOM_NUMBER_START, RANDOM_NUMBER_END));
    }

    private int[] generateRandomNumbers(int randomNumberLength, int start, int end) {
        int[] gameRandomNumber = new int[randomNumberLength];

        int i = 0;
        while (!isGameRandomNumberGenerated(gameRandomNumber)) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!validation.validateIsNumberExist(gameRandomNumber, randomNumber)) {
                gameRandomNumber[i] = randomNumber;
                i ++;
            }
        }
        return gameRandomNumber;
    }

    private boolean isGameRandomNumberGenerated(int[] gameRandomNumber) {
        for (int number : gameRandomNumber) {
            if (number == 0) {
                return false;
            }
        }
        return true;
    }

    public void gameInProgress () {
        int strike = 0;
        while (strike != 3) {
            startGame();
            outPut.resultMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void startGame() {
        game.setCountZero();
        userInPut.choiceNumberMessage();
        String userChoiceNum = Console.readLine();

        user.setUserChoiceNumber(userChoiceNum);
        validation.validateUserChoiceNumSize(userChoiceNum);
        decisionUserChoiceNum(game.getGameRandomNumber(), user.getUserChoiceNumber());
    }

    private void decisionUserChoiceNum (int[] gameRandomNumber, String userChoiceNumber) {
        for (int i = 0; i < userChoiceNumber.length(); i++) {
            int extractedNumber = util.parseCharToInt(userChoiceNumber.charAt(i));
            if (validation.validateIsNumberExist(gameRandomNumber, extractedNumber)) {
                if (extractedNumber == gameRandomNumber[i]) {
                    game.addStrikeCount();
                } else {
                    game.addBallCount();
                }
            }

            validation.validateIsCharacter(extractedNumber);
        }
    }

    public void gameRestart() {
        while (isGameRestart()) {
            setGame();
            gameInProgress();
        }
    }

    private boolean isGameRestart() {
        userInPut.startAgainOptionMessage();
        return outPut.promptForGameRestart();
    }
}
