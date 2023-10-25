package baseball;

public class Score {

    public int numOfBall = 0;
    public int numOfStrike = 0;

    private static Score score;

    private Score() {
    }

    public static Score getInstance() {
        if (score == null) {
            score = new Score();
        }
        return score;
    }

    public Score(int numOfBall, int numOfStrike) {
        this.numOfBall = numOfBall;
        this.numOfStrike = numOfStrike;
    }

    public void initializeScore() {
        numOfBall = 0;
        numOfStrike = 0;
    }

    public boolean isSuccess() {
        if (numOfStrike == 3) {
            initializeScore();
            return true;
        }

        initializeScore();
        return false;
    }

    public void printOutScore() {
        if (numOfBall == 0 && numOfStrike == 0) {
            System.out.print("낫싱");
        } else {
            if (!(numOfBall == 0)) {
                System.out.printf("%d볼 ", numOfBall);
            }
            if (!(numOfStrike == 0)) {
                System.out.printf("%d스트라이크", numOfStrike);
            }
        }
    }

    public Score returnScore(Computer computer, User user) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.getRandomNumber().get(i).equals(user.getInputNumber().get(j))) {
                    if (i == j) {
                        numOfStrike++;
                        break;
                    } else {
                        numOfBall++;
                        break;
                    }
                }
            }
        }
        return new Score(numOfBall, numOfStrike);
    }
}
