package baseball;

import baseball.game.hitter.PlayerHitterImpl;

public class Application {
    public static void main(String[] args) {
        PlayerHitterImpl hitter = new PlayerHitterImpl();

        String bat = "";

        System.out.println("입력:");
        bat = hitter.swing();
    }
}
