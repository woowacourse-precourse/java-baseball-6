package baseball.domain;

public class Game {
    private int strikes;
    private int balls;

    public Game() {
        // 게임 초기화 로직
        this.strikes =  0;
        this.balls = 0;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    // 게임의 결과를 업데이트하는 메서드
    public void updateGameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    // 게임 초기화 메서드
    public void resetGame() {
        this.strikes = 0;
        this.balls = 0;
    }


}


