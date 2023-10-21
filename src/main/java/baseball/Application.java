package baseball;

import baseball.controller.GameController;
import baseball.utils.RandomUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] answer = RandomUtils.getRandomNumbers();

        System.out.println("숫자를 입력해주세요 : ");
        GameController.getInputNumber(answer);
    }
}
