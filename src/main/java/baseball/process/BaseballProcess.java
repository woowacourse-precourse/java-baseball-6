package baseball.process;

import java.util.List;

public class BaseballProcess {

    private final RandomNumber randomNumber = RandomNumber.of();
    private final InputNumber inputNumber = InputNumber.of();

    private BaseballProcess() {
    }

    public static BaseballProcess of() {
        return new BaseballProcess();
    }
    public void start() {
        System.out.print(ApplicationConstant.START_GAME_MESSAGE);
        boolean isCheck = true;
        while (isCheck) {
            playRound();
            int status = inputNumber.inputStatus();
            isCheck = isRestart(status);
        }
        stop();
    }

    public void playRound() {
        List<Integer> computer = createRandom();
        boolean isCheck = true;
        while (isCheck) {
            List<Integer> player = inputNumber.inputNumber();
            getCount(computer, player);
            isCheck = isContinue(computer, player);
        }
    }

    public List<Integer> createRandom() {
        return randomNumber.getRandomNumber();
    }

    public void getCount(List<Integer> computer, List<Integer> player) {
        int ball = accountBall(computer, player);
        int strike = accountStrike(computer, player);
        printResult(ball, strike);
    }

    public boolean isBall(int index, List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == player.get(index) && i != index) {
                return true;
            }
        }
        return false;
    }

    public boolean isStrike(int index, List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == player.get(index) && i == index) {
                return true;
            }
        }
        return false;
    }

    public int accountBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        for (int i = 0; i < player.size(); i++) {
            if (isBall(i, computer, player)) {
                ball++;
            }
        }
        return ball;
    }

    public int accountStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (isStrike(i, computer, player)) {
                strike++;
            }
        }
        return strike;
    }

    public void printResult(int ball, int strike) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean isContinue(List<Integer> computer, List<Integer> player) {
        int strike = accountStrike(computer, player);
        if (strike == 3) {
            System.out.print(ApplicationConstant.FINISH_ROUND_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isRestart(int status) {
        if (status == 1) {
            return true;
        }
        return false;
    }

    public void stop() {
        System.out.println("게임을 종료합니다.");
    }
}
