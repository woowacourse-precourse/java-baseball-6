package playGame;

import baseball.Game;

public class Control {

    Game game = new Game();

    public void run() {
        game.startGame();
        game.setGame();
        while (true) {
            playGame();
            game.endGame();

                int reStartCommand = game.reStart();
                if (reStartCommand == 2) {
                    System.out.println("게임 종료");
                    break;
                } else if (reStartCommand == 1) {
                    reStartGame();
                }


        }

    }

    public void reStartGame() {
        game.setGame();
        game.setStrikeAndBall();
    }

    public void playGame() {
        while (!game.isOver()) {

                game.inputNum();

            game.check_num();
            game.printResult();
        }
    }


}
