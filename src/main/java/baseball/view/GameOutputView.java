package baseball.view;

public class GameOutputView {

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printAnswerComparisonResult(int numOfBalls, int numOfStrikes) {
        if (numOfBalls == 0 && numOfStrikes == 0) {
            System.out.println("낫싱");
            return;
        }
        String resultMessage = String.join(
                " ", getNumOfBallsMessage(numOfBalls), getNumOfStrikesMessage(numOfStrikes)
        ).trim();
        System.out.println(resultMessage);
    }

    private static String getNumOfBallsMessage(int numOfBalls) {
        if (numOfBalls == 0) {
            return "";
        }
        return numOfBalls + "볼";
    }

    private static String getNumOfStrikesMessage(int numOfStrikes) {
        if (numOfStrikes == 0) {
            return "";
        }
        return numOfStrikes + "스트라이크";
    }
}
