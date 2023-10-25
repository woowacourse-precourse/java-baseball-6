package baseball;

public class Score {

    private int numOfBall;
    private int numOfStrike;

    private static Score score;

    private Score() {
    }

    public static Score getInstance() {
        if (score == null) {
            score = new Score();
        }
        return score;
    }

    public void calculateScore(Computer computer, User user) {
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

    public boolean isSuccess() {
        if (numOfStrike == 3) {
            initializeScore();
            return true;
        }
        initializeScore();
        return false;
    }

    private void initializeScore() {
        numOfBall = 0;
        numOfStrike = 0;
    }
}
