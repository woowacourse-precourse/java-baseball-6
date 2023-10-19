package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame rightAnswer = new BaseBallGame();
    }

    class Array() {

    }


    class BaseBallGame() {
        private static final int START_RANGE = 1;
        private static final int END_RANGE = 9;
        final int NUMBER_IDX = 3;
        private static final int NEW_GAME = 1;
        private static final int QUIT_GAME = 2;

        int[] computer = new int[NUMBER_IDX];

    }

    class GameResult() {
        int ball = 0, strike = 0;

        private static final String BALL = "볼";
        private static final String STRIKE = "스트라이크";
        private static final String NOTHING = "낫싱";

        private void addBallCount() {
            this.ball++;
        }
        private void addStrikeCount() {
            this.strike++;
        }

        public void printResult() {
            if(this.strike != 3) {
                if (this.ball > 0 && this.strike > 0)
                    System.out.println(this.ball + BALL + " " + this.strike + STRIKE);
                if (this.ball != 0)
                    System.out.println(this.ball + BALL);
                else if(this.ball == 0 && this.strike > 0)
                    System.out.println(this.strike + STRIKE);
                else if(this.ball == 0 && this.strike == 0)
                    System.out.println(NOTHING);
            }
            else System.out.println(this.strike + "스트라이크"); // 3스트라이크
        }
    }
}
