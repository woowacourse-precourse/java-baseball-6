package baseball;

public class Application {
    public static void main(String[] args) {

        while (true){
            Game game = new Game();
            game.gameStart();

            Player player = game.createPlayer();
            Referee referee = game.getReferee();

            while (!referee.getCall().equals("3스트라이크")){
                player.inputNumber();
                referee.judgement(game.getNumbers(), player.getGuessNumbers());
                referee.call();
            }

            game.gameClear();
            game.gameRestart();

            if (game.isGameFinished()) return;
        }

    }
}
