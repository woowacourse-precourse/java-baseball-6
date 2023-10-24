package baseball.mock;

import baseball.domain.game.ContinueAnswer;
import baseball.domain.player.BaseballPlayer;

public class FakePlayer implements BaseballPlayer {
        private final ContinueAnswer answer;
        private final String number;
        private int retryCount = 0;

        public FakePlayer(ContinueAnswer answer, String number) {
                this.answer = answer;
                this.number = number;
        }

        @Override
        public String submitThreeNumber(int limitLength) {
                return number;
        }

        @Override
        public ContinueAnswer responseContinuePlay() {
                if (retryCount > 0) {
                        return ContinueAnswer.NO;
                }

                retryCount += 1;
                return answer;
        }
}
