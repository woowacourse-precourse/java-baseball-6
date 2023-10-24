package game;

import static input.User.userDecision;
import static game.Compare.startCompare;

public class Game {
    private static final String RESTART = "1";
    private static final String QUIT = "2";

    public void runGame() {
        String restart = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(restart.equals(RESTART)) {
            startCompare();
            restart = restart();
            if(restart.equals(QUIT)) {
                break;
            }
        }
    }
    public String restart(){
        String decision = userDecision();
        return decision;
    }
}
