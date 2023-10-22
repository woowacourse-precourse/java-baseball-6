package baseball;

public class Game {
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private int strike;
    private int ball;
    private User user;
    private Computer computer;

    public boolean checkAndCalcUserGuess(User user, Computer computer) {
        // Todo : user.list와 computer.list를 비교해 3스트라이크이면 3 리턴
        // Todo : game의 필드 변수인 strike와 ball 값 계산
        return false;
    }
}
