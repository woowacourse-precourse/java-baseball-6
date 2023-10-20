package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.GameUtil;
import baseball.view.OutPut;
import baseball.view.UserInPut;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Service {
    Game game = new Game();
    User user = new User();
    GameUtil gameUtil = new GameUtil();

    OutPut outPut = new OutPut();

    UserInPut userInPut = new UserInPut();

    public void setGame() {
        game.setCountZero();
        game.setRandomNumber(gameUtil.ComputerChoiceNumber(3, 1, 9));
    }

    public void onGame () {
        int strike = 0;
        while (strike != 3) {
            startGame();
            outPut.resultMessage(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }

    }

    public void startGame() {
        game.setCountZero();
        UserInPut.choiceNumberMessage();
        String userChoiceNum = Console.readLine();

        user.setUserChoiceNumber(userChoiceNum);
        validateUserChoiceNumSize(userChoiceNum);
        decisionUserChoiceNum(game.getRandomNumber(), userChoiceNum);
    }


    public void validateUserChoiceNumSize (String userChoiceNum) {
        if (userChoiceNum.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void decisionUserChoiceNum (ArrayList<Integer> randomNumber, String userChoice) {
        for (int i = 0; i < userChoice.length(); i++) {
            if (randomNumber.contains(userChoice.charAt(i) - '0')) {
                if ((userChoice.charAt(i)) - '0' == randomNumber.get(i)) {
                    game.addStrikeCount();
                } else {
                    game.addBallCount();
                }
            }
        }
    }

    public void gameRestart() {
        if (isGameContinue()) {
            onGame();
        }
    }

    public boolean isGameContinue() {
        userInPut.startAgainOptionMessage();
        return outPut.isGameContinue();
    }

}
