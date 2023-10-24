package baseball;

import baseball.domain.game.BaseballGame;
import baseball.domain.game.Game;
import baseball.domain.judgement.Judgement;
import baseball.domain.player.BaseballGameParticipant;
import baseball.domain.player.BaseballPlayer;
import baseball.domain.player.Computer;
import baseball.util.GameConsoleReader;

public class Application {
        public static void main(String[] args) {
                Judgement judgement = new Computer();
                BaseballPlayer computer = (BaseballPlayer) judgement;
                BaseballPlayer user = new BaseballGameParticipant(new GameConsoleReader());
                Game baseballGame = new BaseballGame(judgement, computer, user);

                baseballGame.start();
        }
}
