package baseball;

import baseball.service.GameManage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final GameManage gameManage = new GameManage();
        gameManage.init();
    }


}
