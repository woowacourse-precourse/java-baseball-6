package baseball.console;

public class Output {
    private static final String ballMessage = "%d볼\n";
    private static final String strikeMessage = "%d스트라이크\n";
    private static final String ballAndStrikeMessage = "%d볼 %d스트라이크\n";
    private static final String nothingMessage = "낫싱\n";
    private static final String answerMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public static void print(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            printNothingMessage();
        } else if (ball == 0) {
            printStrikeMessage(strike);
        } else if (strike == 0) {
            printBallMessage(ball);
        } else {
            printBallAndStirkeMessage(ball, strike);
        }
    }

    public static void printBallMessage(int ball) {
        System.out.printf(ballMessage, ball);
    }

    public static void printStrikeMessage(int strike) {
        System.out.printf(strikeMessage, strike);
    }

    public static void printBallAndStirkeMessage(int ball, int strike) {
        System.out.printf(ballAndStrikeMessage, ball, strike);
    }

    public static void printNothingMessage() {
        System.out.printf(nothingMessage);
    }

    public static void printAnswerMessage() {
        System.out.printf(answerMessage);
    }
}