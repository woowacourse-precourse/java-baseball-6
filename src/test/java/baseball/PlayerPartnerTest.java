package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PlayerPartnerTest {
    static int[] 정답들 = {9, 1, 5};

    private final int[] 볼스트라이크 = {
            123, 345, 234, 521, 945,
            175, 582, 852, 126, 124,
            416, 867, 562, 986, 915};

    private final int[] 스트라이크갯수들 = {
            0, 1, 0, 0, 2,
            1, 0, 0, 0, 0,
            1, 0, 0, 1, 3};

    private final int[] 볼갯수들 = {
            1, 0, 0, 2, 0,
            1, 1, 1, 1, 1,
            0, 0, 1, 0, 0};

    static abstract class NumberClassifier {
        private int ballCount = 0;
        private int strikeCount = 0;

        protected int getBallCount() {
            return this.ballCount;
        }

        protected int getStrikeCount() {
            return this.strikeCount;
        }

        protected void compareNumbers(int playerNumbers, int partnerNumbers) {
            int[] ballsCount = getBallsCount(playerNumbers, partnerNumbers);
            int allCount = ballsCount[0];
            int strikeCount = ballsCount[1];
            int ballCount = getBallCount(allCount, strikeCount);

            setBallsCount(strikeCount, ballCount);
        }

        private int[] getBallsCount(int playerNumbers, int partnerNumbers) {
            int[] ballsCount = new int[2];

            while (playerNumbers % 10 > 0) {
                int playerNumber = playerNumbers % 10;
                int partnerNumber = partnerNumbers % 10;

                if (isBallStrike(playerNumber)) {
                    ballsCount[0]++;
                }

                if (isStrike(playerNumber, partnerNumber)) {
                    ballsCount[1]++;
                }

                playerNumbers /= 10;
                partnerNumbers /= 10;
            }

            return ballsCount;
        }

        protected abstract boolean isBallStrike(int playerNumber);

        protected abstract boolean isStrike(int playerNumber, int partnerNumber);

        private int getBallCount(int allCount, int strikeCount) {
            if (allCount - strikeCount < 0) {
                return 0;
            } else {
                return allCount - strikeCount;
            }
        }

        private void setBallsCount(int strikeCount, int ballCount) {
            this.strikeCount = strikeCount;
            this.ballCount = ballCount;
        }
    }

    static class PlayerPartner extends NumberClassifier {
        private int answer = 0;
        private boolean[] answerSheet = new boolean[10];

        public static PlayerPartner inputAnswerOf(int[] answers) {
            return new PlayerPartner(answers);
        }

        private PlayerPartner() {

        }

        private PlayerPartner(int[] answers) {
            int multiple = 100;

            for (Integer number : answers) {
                this.answer += number * multiple;
                this.answerSheet[number] = true;
                multiple /= 10;
            }
        }

        /*public void startGame() {
            while (isContinue(getStrikeCount())) {
                Player player = Player.inputNumberOf(readLine());
                int playerNumbers = player.getNumber();

                compareNumbers(playerNumbers, this.answer);
                printBallStatus(getStrikeCount(), getBallCount());
            }
        }*/

        private boolean isContinue(int strikeCount) {
            return strikeCount < 3;
        }

        @Override
        protected boolean isBallStrike(int playerNumber) {
            return this.answerSheet[playerNumber];
        }

        @Override
        protected boolean isStrike(int playerNumber, int partnerNumber) {
            return playerNumber == partnerNumber;
        }

        private void printBallStatus(int strikeCount, int ballCount) {
            StringBuffer message = new StringBuffer();

            if (ballCount > 0) {
                message.append(ballCount + "볼 ");
            }

            if (strikeCount > 0) {
                message.append(strikeCount + "스트라이크");
            }

            if (ballCount == 0 && strikeCount == 0) {
                message.append("낫싱");
            }

            System.out.println(message.toString());
        }
    }

    private PlayerPartner input(int[] answers) {
        return PlayerPartner.inputAnswerOf(answers);
    }

    @Test
    void 정답입력_확인() {
        PlayerPartner playerPartner = input(정답들);

        assertThat(playerPartner.answer).isGreaterThan(0);
    }

    @Test
    void 볼스트라이크_확인() {
        PlayerPartner playerPartner = input(정답들);

        for (int i = 0; i < 볼스트라이크.length; i++) {
            int 플레이어_숫자 = 볼스트라이크[i];
            int 스트라이크개수 = 스트라이크갯수들[i];
            int 볼개수 = 볼갯수들[i];
            playerPartner.compareNumbers(플레이어_숫자, playerPartner.answer);

            assertThat(playerPartner.getStrikeCount()).isEqualTo(스트라이크개수);
            assertThat(playerPartner.getBallCount()).isEqualTo(볼개수);
        }
    }

}
