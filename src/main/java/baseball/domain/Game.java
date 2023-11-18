package baseball.domain;
import camp.nextstep.edu.missionutils.Randoms;


public class Game {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }
    public void initBaseball(){ //스트라이크 와 볼의 수 0으로 초기화
        strikeCount = 0;
        ballCount = 0;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
    public int getBallCount() {
        return ballCount;
    }
    public int[] getGameNumbers() {
        return gameNumbers;
    }
    public void incStrikeCount() {
        strikeCount += 1;
    }

    public void incBallCount() {
        ballCount += 1;
    }





}