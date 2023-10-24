package baseball.Service;


import baseball.Domain.Game;
import baseball.Domain.User;
import baseball.View.RequestMessageView;
import baseball.View.ResponseMessageView;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    int SIZE = 3;
    Game game;
    User user = new User();

    public void setGame(){
        int[] randomNumbers = RandomNumber.randomNumber();
        game = new Game(randomNumbers);
    }

    public void playGame() {
        int strike = 0;
        while (strike != 3) {
            initTurn();
            ResponseMessageView.inputNumberResultPrint(game.getBallCount(), game.getStrikeCount());
            strike = game.getStrikeCount();
        }
    }

    public void initTurn() {
        game.initBaseBall();
        user.setUserNumbers(getUserNumber());
        computeScore();
    }

    private int[] getUserNumber() throws IllegalArgumentException {
        RequestMessageView.inputNumberRequestPrint();
        String input = Console.readLine();
        return Parser.parseUserInput(input, SIZE);
    }

    private void computeScore() {
        for (int i = 0; i < SIZE; i++) {
            compute(game.getGameNumbers(), user.getUserNumbers(), i);
        }
    }

    private void compute(int[] gameNumber, int[] userNumber, int index) {
        int temp = -1;
        for (int i = 0; i < gameNumber.length; i++) {
            if(gameNumber[i] == userNumber[index]) {
                temp = i;
                break;
            }
        }
        correctCount(index, temp);
    }

    private void correctCount(int index, int temp) {
        if (temp != index && temp != -1) {
            game.ballCount();
        }
        if (temp == index) {
            game.strikeCount();
        }
    }
}
