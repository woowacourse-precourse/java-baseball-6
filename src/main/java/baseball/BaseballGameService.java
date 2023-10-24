package baseball;

import java.util.Objects;

public class BaseballGameService {
    private BaseballNumber computerNumber;

    public BaseballGameService() {
        this.computerNumber = BaseballNumber.generateRandom();
    }

//    // 테스트 전용 생성자
//    public BaseballGameService(BaseballNumber computerNumber) {
//        this.computerNumber = computerNumber;
//    }

    public BaseballNumber getComputerNumber() {
        return computerNumber;
    }

    // 숫자 비교
    public GameResult guess(String input) {
        BaseballNumber playerNumber = BaseballNumber.from(input);
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumber.getNumbers().get(i), playerNumber.getNumbers().get(i))) {
                strikes++;
            } else if (computerNumber.getNumbers().contains(playerNumber.getNumbers().get(i))) {
                balls++;
            }
        }

        return new GameResult(strikes, balls);
    }

    // 게임 다시 시작
    public void reset() {
        this.computerNumber = BaseballNumber.generateRandom();
    }
}
