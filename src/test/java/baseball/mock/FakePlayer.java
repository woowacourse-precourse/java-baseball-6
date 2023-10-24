package baseball.mock;

import baseball.domain.game.RetryAnswer;
import baseball.domain.player.BaseballPlayer;

public class FakePlayer implements BaseballPlayer {
        private final RetryAnswer answer;
        private final String number;
        private int retryCount = 0;

        public FakePlayer(RetryAnswer answer, String number) {
                this.answer = answer;
                this.number = number;
        }

        @Override
        public String provideLimitedNumber(int limitLength) {
                return number;
        }

        @Override
        public RetryAnswer responseRetryPlay() {
                if (retryCount > 0) {
                        return RetryAnswer.NO;
                }

                retryCount += 1;
                return answer;
        }
}
