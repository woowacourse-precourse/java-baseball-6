package baseball;

import baseball.service.service;
import baseball.utils.randomComputer;
import baseball.view.judgeView;
import baseball.view.userView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void Game() {
        List<Integer> user = new ArrayList<>();
        boolean again = true;
        randomComputer randomComputer = new randomComputer();
        userView userView = new userView();
        service service = new service();
        judgeView judgeView = new judgeView();

        while (again) {
            userView.gameStart();
            int[] computer = randomComputer.computerRandom();
            while (true) {
                userView.userInputMessage();
                user = service.userInput();

                judgeView.judgeBaseball(computer, user);

                if (judgeView.countThreeStrike()) {
                    judgeView.victoryScore();
                    again = service.playAgain();
                    break;
                }
            }

        }
    }
}
