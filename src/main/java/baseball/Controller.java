package baseball;

import baseball.service.service;
import baseball.utils.checkExceptionUser;
import baseball.utils.randomComputer;
import baseball.view.judgeView;
import baseball.view.userView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void run() {
        List<Integer> user = new ArrayList<>();
        randomComputer randomComputer = new randomComputer();
        userView userView = new userView();
        service service = new service();

        userView.gameStart();
        while (true) {
            judgeView judgeView = new judgeView();
            String computer = randomComputer.getComputerRandomNumber();
            user = service.userInput();
            int[] resultBaseball = service.judgeBaseball(computer, user);
            judgeView.countResult(resultBaseball);

            if (judgeView.countThreeStrike()) {
                judgeView.victoryScore();
                break;
            }
        }
    }

    public int askRetryInput() {
        userView userView = new userView();
        checkExceptionUser check = new checkExceptionUser();

        String userregameNum = userView.userRegameMessage();
        int userRegameNum = Integer.parseInt(userregameNum);
        check.checkUserRegameException(userRegameNum);

        return userRegameNum;
    }
}
