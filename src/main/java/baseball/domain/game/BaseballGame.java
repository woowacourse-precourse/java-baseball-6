package baseball.domain.game;

import baseball.domain.judgement.GameState;
import baseball.domain.judgement.BaseballJudgement;
import baseball.domain.player.BaseballPlayer;

/**
 * BaseballGame 은 숫자 야구 게임의 개념 객체를 나타내는 클래스입니다.
 * 숫자 야구 게임은 2 명의 플레이어와 1명의 심판이 참여합니다.
 */
public class BaseballGame implements Game {
        /**
         * 숫자 야구 게임의 심팜입니다.
         */
        private final BaseballJudgement judgement;

        /**
         * 숫자 야구 게임에 참여하는 플레이어 A 입니다.
         */
        private final BaseballPlayer playerA;

        /**
         * 숫자 야구 게임에 참여하는 플레이어 B 입니다.
         */
        private final BaseballPlayer playerB;

        /**
         * 숫자 야구 게임에서 사용되는 숫자열 제한 길이 상수입니다.
         */
        private static final int LIMIT_NUMBER_LENGTH = 3;

        /**
         * BaseballGame 객체를 생성하는 생성자입니다.
         *
         * @param judgement 야구 게임 심판
         * @param playerA 야구 게임에 참여한 플레이어 A
         * @param playerB 야구 게임에 참여한 플레이어 B
         */
        public BaseballGame(BaseballJudgement judgement, BaseballPlayer playerA, BaseballPlayer playerB) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                this.judgement = judgement;
                this.playerA = playerA;
                this.playerB = playerB;
        }


        /**
         * 게임을 시작하고, 게임이 끝나면 재시작 메서드를 호출합니다.
         * 게임이 시작되면 플레이어가 선택한 숫자열을 심판이 판단하고, 게임 진행 상태를 반환합니다.
         */

        @Override
        public void start() {
                GameState gameState;
                String player1Num = playerA.provideLimitedNumber(LIMIT_NUMBER_LENGTH);

                do {
                        String player2Num = playerB.provideLimitedNumber(LIMIT_NUMBER_LENGTH);

                        gameState = judgement.judgementGameState(player1Num, player2Num);
                } while (gameState.equals(GameState.PROGRESS));

                askRetry();
        }

        /**
         * 게임이 종료되면 플레이어에게 개임의 재시작 여부를 묻고, 게임의 재시작 또는 종료 동작을 수행합니다.
         */
        @Override
        public void askRetry() {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                RetryAnswer playAContinueAnswer = playerA.responseRetryPlay();
                RetryAnswer playBContinueAnswer = playerB.responseRetryPlay();

                if (playBContinueAnswer.equals(RetryAnswer.YES)
                        && playAContinueAnswer.equals(RetryAnswer.YES)) {

                        this.start();

                        return;
                }

                this.finish();
        }

        /**
         * 게임 종료 문자를 console 에 출력합니다.
         */
        @Override
        public void finish() {
                System.out.println("게임 종료");
        }
}
