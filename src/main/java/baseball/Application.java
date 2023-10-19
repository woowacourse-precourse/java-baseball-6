package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BaseballGame baseballGame = new BaseballGame(new RandomNumberProviderImpl());
            baseballGame.start();
        } catch (Exception e) {
            throw e;
        }

    }
}
