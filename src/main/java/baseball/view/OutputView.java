package baseball.view;

public class OutputView {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String END_MASSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage() {
      System.out.println(START_MESSAGE);
    }

    public static void printRestartMessage() {
      System.out.println(RESTART_MESSAGE);
    }

    public static void printEndMessage() {
      System.out.println(END_MASSAGE);
    }

    public static void printNothingScore() {
      System.out.println("낫싱");
    }

    public static void printBallScore(int ballScore) {
      System.out.print(ballScore+"볼 ");
    }
    
    public static void printStrikeScore(int strikeScore) {
        System.out.println(strikeScore+"스트라이크");
    }

}