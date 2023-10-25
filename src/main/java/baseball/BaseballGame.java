package baseball;

import baseball.User;
import baseball.Computer;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private User user;
    private Computer computer;

    private boolean gameState = true;

    public void startGame() {
        Message.startMessage();
        while (gameState) {
            user = new User();
            computer = new Computer();
            computer.makeRandomNum();
            playGame();
            Message.gameEndMessage();
            gameState = endGame();

        }
    }

    //todo: 게임 종료 선택시 gameState=false
    private void playGame() {
        while (true) {
            Message.inputReqMessage();
            user.makeUserNum();
            user.ball = (computer.computeBall(user.userAnswer));
            user.strike = (computer.computeStrike(user.userAnswer));
            Message.scoreMessage(user.ball, user.strike);
            if (user.strike == 3) {
                Message.winMessage();
                break;
            }
        }
    }

    private boolean endGame() {
        String input = Console.readLine();
        InputVerification.verifyEndInput(input);
        return input.charAt(0) != '2';
    }
}
