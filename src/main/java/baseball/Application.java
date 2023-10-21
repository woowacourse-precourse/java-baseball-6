package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        RandomValue randomValue = new RandomValue();
        Game game = new Game();

        List<Integer> randomNumber = randomValue.createRandomNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        game.play();

    }
}
