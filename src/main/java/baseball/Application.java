package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        player.playGame(computer);
    }
}