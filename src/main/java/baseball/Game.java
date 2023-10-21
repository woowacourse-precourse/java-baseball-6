package baseball;

import java.util.List;

public class Game {

    private final User user;

    private final Computer computer;

    public Game(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    public void play() {
        boolean isEnd = false;

        GameMessage.WELCOME.print();
        computer.selectBalls();
        do {
            user.selectBalls();
            isEnd = checkResult(user, computer);
        } while (!isEnd);
        GameMessage.WIN.print();
    }

    private boolean checkResult(User user, Computer computer) {
        List<Integer> userBalls = user.getBalls();
        List<Integer> computerBalls = computer.getBalls();
        int strike = 0;
        int ball = 0;

        for (int i : userBalls) {
            if (computerBalls.contains(i)) {
                if (computerBalls.indexOf(i) == userBalls.indexOf(i)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        GameMessage.printResult(strike, ball);
        return (strike == 3);
    }
}
