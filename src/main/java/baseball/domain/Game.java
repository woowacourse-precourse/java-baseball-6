package baseball.domain;
import java.util.ArrayList;
import java.util.List;

public class Game {
    int strikeCount;
    int ballCount;
    int[] gameNumbers;

    public Game(int[] numbers) {
        gameNumbers = numbers;
    }
    public void initBaseBall(){ //스트라이크 와 볼의 수 0으로 초기화
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


    //RandomNumbers
    public List<Integer> getRandomNumbers() {

        return RandomNumbers;
    }

    public void setRandomNumbers(List<Integer> randomNumbers) {
        RandomNumbers = randomNumbers;
    }

    List<Integer> RandomNumbers = new ArrayList<>();
}
