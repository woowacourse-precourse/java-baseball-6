package process;

import java.util.List;

public class BaseballProcess {

    private final RandomNumber randomNumber = RandomNumber.of();
    private final InputNumber inputNumber = InputNumber.of();

    private BaseballProcess() {
    }

    public static BaseballProcess of() {
        return new BaseballProcess();
    }

    public void playGame() {
        System.out.println("게임을 시작합니다.");
        boolean isCheck = true;
        while (isCheck) {
            playRound();
            int status = inputNumber.getInputStatus();
            isCheck = isRestart(status);
        }
        stop();
    }

    public void playRound() {
        List<Integer> computer = createRandom();
        boolean isCheck = true;
        while (isCheck) {
            List<Integer> player = inputNumber.getInputNumber();
            String result = getCount(computer, player);
            System.out.println(result);
            isCheck = isFinish(computer, player);
        }
    }

    public String getCount(List<Integer> computer, List<Integer> player) {
        int ball = accountBall(computer, player);
        int strike = accountStrike(computer, player);
        return getResult(ball, strike);
    }

    public void stop() {
        System.out.println("게임을 종료합니다.");
    }

    public List<Integer> createRandom() {
        return randomNumber.getRandomNumber();
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

    public String getResult(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball);
            sb.append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike);
            sb.append("스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }

    public boolean isFinish(List<Integer> computer, List<Integer> player) {
        int strike = accountStrike(computer, player);
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
}
