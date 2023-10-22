package baseball.controller;

import baseball.model.Numbers;
import baseball.view.UserViewer;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private final static UserViewer viewer = new UserViewer();
    public User() {

    }

    public List<Integer> userInput() {
        viewer.showUserInput();
        String userInputNumbers = Console.readLine();
        return new Numbers(userInputNumbers).getNumbers();
    }
}
