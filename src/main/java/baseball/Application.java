package baseball;

import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballService baseballService = new BaseballService();
        baseballService.playBaseballGame();
    }
}
