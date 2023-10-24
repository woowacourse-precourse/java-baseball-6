package baseball;

import baseball.util.OutputUtil;

public class Ground {
    Computer computer = new Computer();
    User user = new User();
    Referee referee = new Referee();
    public void startGame() {
        OutputUtil.printStartGame();
        String baseballNum = computer.createValidBaseballNum();
        while (true) {
            if (getTurn(baseballNum)) break;
        }
    }

    private boolean getTurn(String baseballNum) {
        String userNum = user.getNum();
        Score score = referee.compare(baseballNum, userNum);
        OutputUtil.printScore(score);
        if (Referee.isGameEnd(score)) {
            if (!user.continueGame()) {
                return true;
            }
        }
        return false;
    }
}
