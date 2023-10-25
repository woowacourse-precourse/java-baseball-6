package baseball;


import baseball.game.Controller;
import baseball.game.View;


public class Application {
    public static void main(String[] args) {
        new Controller(new View()).init();
    }
}
