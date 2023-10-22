package baseball;

public class Game {
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private int strike = 0;
    private int ball = 0;

    private int N = Variables.NUM.getValue();

    public boolean checkAndCalcUserGuess(User user, Computer computer) {
        // Todo : user.list와 computer.list를 비교해 3스트라이크이면 3 리턴
        // Todo : game의 필드 변수 strike와 ball 값 계산

        for (int i = 0; i < N; i++) {
            if (user.getUserList().get(i).equals(computer.getComputerList().get(i))) {
                strike++;
            } else if (computer.getComputerList().contains(user.getUserList().get(i))) {
                ball++;
            }
        }

        return (strike == 3);
    }
}
