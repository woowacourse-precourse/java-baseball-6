package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.GameUtil;
import baseball.view.OutPut;
import baseball.view.UserInPut;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Service {
    Game game = new Game();
    User user = new User();
    GameUtil gameUtil = new GameUtil();
    OutPut outPut = new OutPut();
    UserInPut userInPut = new UserInPut();

    public void setGame() {
        game.setCountZero();
        game.setRandomNumber(ComputerChoiceNumber(3, 1, 9));
    }

    private int[] ComputerChoiceNumber(int randomNumberLength, int start, int end) {
        int[] gameRandomNumber = new int[randomNumberLength];
        int i = 0;
        while (!isExistNumber(gameRandomNumber)) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (gameUtil.validateExistNumber(gameRandomNumber, randomNumber)) {
                gameRandomNumber[i] = randomNumber;
                i ++;
            }
        }
        return gameRandomNumber;
    }

    private boolean isExistNumber(int[] gameRandomNumber) {
        for (int number : gameRandomNumber) {
            if (number == 0) {
                return false;
            }
        }
        return true;
    }

    public void onGame () {
        int strike = 0;
        while (strike != 3) {
            startGame();
            outPut.resultMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    private void startGame() {
        game.setCountZero();
        UserInPut.choiceNumberMessage();
        String userChoiceNum = Console.readLine();

        user.setUserChoiceNumber(userChoiceNum);
        validateUserChoiceNumSize(userChoiceNum);
        decisionUserChoiceNum(game.getRandomNumber(), user.getUserChoiceNumber());
    }

    private void validateUserChoiceNumSize (String userChoiceNum) {
        if (userChoiceNum.length() != 3) {
            throw new IllegalArgumentException("옳지 못한 입력입니다");
        }
    }

    private void decisionUserChoiceNum (int[] randomNumber, String userChoice) {
        for (int i = 0; i < userChoice.length(); i++) {
            if (!gameUtil.validateExistNumber(randomNumber, userChoice.charAt(i) - '0')) {
                if ((userChoice.charAt(i)) - '0' == randomNumber[i]) {
                    game.addStrikeCount();
                } else {
                    game.addBallCount();
                }
            }
        }
    }

    public void gameRestart() {
        while (isGameContinue()) {
            setGame();
            onGame();
        }
    }

    private boolean isGameContinue() {
        userInPut.startAgainOptionMessage();
        return outPut.isGameContinue();
    }
}
