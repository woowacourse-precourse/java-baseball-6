package baseball.domain.game;

import baseball.domain.judgement.GameState;
import baseball.domain.judgement.Judgement;
import baseball.domain.player.BaseballPlayer;

public class BaseballGame implements Game {
        private final Judgement judgement;
        private final BaseballPlayer playerA;
        private final BaseballPlayer playerB;
        private static final int LIMIT_NUMBER_LENGTH = 3;

        public BaseballGame(Judgement judgement, BaseballPlayer playerA, BaseballPlayer playerB) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                this.judgement = judgement;
                this.playerA = playerA;
                this.playerB = playerB;
        }

        @Override
        public void start() {
                GameState gameState;
                String player1Num = playerA.submitThreeNumber(LIMIT_NUMBER_LENGTH);

                do {
                        String player2Num = playerB.submitThreeNumber(LIMIT_NUMBER_LENGTH);

                        gameState = judgement.judgementGameState(player1Num, player2Num);
                } while (gameState.equals(GameState.PROGRESS));

                retry();
        }

        @Override
        public void retry() {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                ContinueAnswer playAContinueAnswer = playerA.responseContinuePlay();
                ContinueAnswer playBContinueAnswer = playerB.responseContinuePlay();

                if (playBContinueAnswer.equals(ContinueAnswer.YES) && playAContinueAnswer.equals(ContinueAnswer.YES)) {
                        this.start();
                        return;
                }

                this.finish();
        }

        @Override
        public void finish() {
                System.out.println("게임 종료");
        }
}
