package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayerPartnerTest {
    static List<Integer> 정답들 = Arrays.asList(9, 1, 5);
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

        static int[] ballsCount = new int[2];

        protected int getBallCount(){
            return ballsCount[0];
        }

        protected int getStrikeCount(){
            return ballsCount[1];
        }

        protected void setBallsCount(int playerNumbers, int partnerNumbers) {
            int allCount = 0;
            int strikeCount = 0;
            int ballCount = 0;

            while (playerNumbers % 10 > 0) {
                int playerNumber = playerNumbers % 10;
                int partnerNumber = partnerNumbers % 10;

                if (checkStrike(playerNumber, partnerNumber)) {
                    strikeCount++;
                }

                if (checkBallStrike(playerNumber)) {
                    allCount++;
                }

                playerNumbers /= 10;
                partnerNumbers /= 10;
            }

            ballCount = getBallCount(allCount, strikeCount);

            this.ballsCount[0] = ballCount;
            this.ballsCount[1] = strikeCount;
        }

        protected abstract boolean checkStrike(int playerNumber, int partnerNumber);

        protected abstract boolean checkBallStrike(int playerNumber);

        private int getBallCount(int allMatchCount, int strikeCount) {
            if (allMatchCount - strikeCount < 0) {
                return 0;
            } else {
                return allMatchCount - strikeCount;
            }
        }
    }

    static class PlayerPartner extends NumberClassifier {
        private int answer = 0;
        private boolean[] answerSheet = new boolean[10];

        public PlayerPartner() {
        }

        private void writeAnswer() {
            // List<Integer> answers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            List<Integer> answers = 정답들;
            int multiple = 100;

            for (Integer number : answers) {
                this.answerSheet[number] = true;
                this.answer += (number * multiple);
                multiple /= 10;
            }
        }

        public void startGame() {
            writeAnswer();

            int strikeCount = 0;

            while (isContinue(strikeCount)) {
                int playerNumbers = Player.nextNumberOf(readLine()).getNumber();
                setBallsCount(playerNumbers, this.answer);

                printBallStatus(getStrikeCount(), getBallCount());
            }
        }

        @Override
        protected boolean checkStrike(int playerNumber, int partnerNumber) {
            return playerNumber == partnerNumber;
        }

        @Override
        protected boolean checkBallStrike(int playerNumber) {
            return this.answerSheet[playerNumber];
        }

        private boolean isContinue(int strikeCount) {
            return strikeCount < 3;
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

    @Test
    void 볼스트라이크_확인() {
        PlayerPartner playerPartner = new PlayerPartner();

        playerPartner.writeAnswer();

        for (int i = 0; i < 볼스트라이크.length; i++) {
            int 플레이어_숫자 = 볼스트라이크[i];
            int 스트라이크개수 = 스트라이크갯수들[i];
            int 볼개수 = 볼갯수들[i];
            playerPartner.setBallsCount(플레이어_숫자, playerPartner.answer);

            assertThat(playerPartner.getStrikeCount()).isEqualTo(스트라이크개수);
            assertThat(playerPartner.getBallCount()).isEqualTo(볼개수);
        }
    }

    /*@Test
    void 볼_확인() {
        PlayerPartner playerPartner = new PlayerPartner();

        playerPartner.writeAnswer();

        for (int i = 0; i < 볼스트라이크.length; i++) {
            int 숫자 = 볼스트라이크[i];
            int 볼개수 = 볼갯수들[i];
            int 상대방_스트라이크개수 = playerPartner.getStrikeCount(숫자);
            int 상대방_볼개수 = playerPartner.getBallCount(숫자, 상대방_스트라이크개수);

            assertThat(상대방_볼개수).isEqualTo(볼개수);
        }
    }*/


}
