package baseball;

import baseball.domain.game.BaseballGame;
import baseball.domain.game.Game;
import baseball.domain.judgement.BaseballJudgement;
import baseball.domain.player.BaseballGameParticipant;
import baseball.domain.player.BaseballPlayer;
import baseball.domain.player.Computer;
import baseball.util.GameConsoleReader;

/**
 * 숫자 야구 게임을 실행시키는 Application 클래스입니다.
 */
public class Application {
        public static void main(String[] args) {
                BaseballJudgement judgement = new Computer();
                BaseballPlayer computer = (BaseballPlayer) judgement;
                BaseballPlayer user = new BaseballGameParticipant(new GameConsoleReader());
                Game baseballGame = new BaseballGame(judgement, computer, user);

                baseballGame.start();
        }
}
