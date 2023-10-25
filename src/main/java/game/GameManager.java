package game;

public class GameManager {
    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGameClass baseballGameClass = new BaseballGameClass();
        while (true) {
            baseballGameClass.gameInit();
            try {
                baseballGameClass.gamePlay();
            } catch (Exception e) {
                throw e;
            }
            if (baseballGameClass.gameExit() == 2) {
                return;
            }
        }
    }
}
