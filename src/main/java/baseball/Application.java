package baseball;

import model.GameMC;

public class Application {
    public static void main(String[] args) {
        // 게임을 진행할 MC 생성
        GameMC gameMC = new GameMC();

        // 게임 스타트!!@@
        gameMC.gameStart();
    }
}
