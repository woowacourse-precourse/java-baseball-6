package baseball.view;

import baseball.model.Computer;

public class GameService {
    Computer computer = new Computer();

    public void generateNdigitAnswer(int n) {
        for (int i = 0; i < n; i++) {
            computer.addDigit();
        }
    }

    public void printAnswer() {
        System.out.println(computer.getAnswer());
    }

}
