package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballNumbers numbers = new BaseballNumbers();
        List<Integer> userNumbers = numbers.createUserNumbers();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.play(userNumbers);
    }
}
