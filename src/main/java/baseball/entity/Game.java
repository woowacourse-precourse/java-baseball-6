package baseball.entity;

public class Game {
        int strikeCount;
        int ballCount;
        int[] gameNumbers;

        public Game(int[] numbers) {
                gameNumbers = numbers;
        }

        public int getStrikeCount() {
                return strikeCount;
        }

        public int getBallCount() {
                return ballCount;
        }

        public int[] getGameNumbers() {
                return gameNumbers;
        }

        public void initBaseBall() {
                strikeCount = 0;
                ballCount = 0;
        }

        public void increaseStrikeCount() {
                strikeCount += 1;
        }

        public void increaseBallCount() {
                ballCount += 1;
        }
}
