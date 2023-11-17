package baseball.domain;
import java.util.ArrayList;
import java.util.List;

public class Game {
    int strikeCount;
    int ballCount;

    public void initBaseBall(){ //스트라이크 와 볼의 수 0으로 초기화
        strikeCount = 0;
        ballCount = 0;
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
