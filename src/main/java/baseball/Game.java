package baseball;

import java.util.List;

public class Game {
    public Game() {
    }

    public void startGame() {

        Number computer = new Number();
        Number player = new Number();

        List<Integer> computerNumber = computer.setRandomNumber();
        // log
        System.out.println("컴퓨터: " + computerNumber);

        List<Integer> playerNumber = player.inputNumber();
        // log
        System.out.println("플레이어: " + playerNumber);

        
    }


}
