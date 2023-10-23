package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import java.util.List;

public class Service {
    Computer computer = new Computer();
    User user = new User();
    InputView inputView = new InputView();
    int ball;
    int strike;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    public void initializeGame() {
        computer.setNumbers();
        computerNumbers = computer.getNumbers();
    }

    public List<Integer> getUserInput(String input) {
        user.setNumbers(input);
        return user.getNumbers();
    }

    public void compareComputerAndUser(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }
}