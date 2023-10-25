package baseball;

public class BaseballGame {

    public static Computer computer = new Computer();
    public static Human human = new Human();

    private static final int BALLS_SIZE = 3;
    private static final int RESTART_DECISION = 1;
    private static final int END_DECISION = 2;
    private static int ballCount = 0;
    private static int strikeCount = 0;

    public static void play() {
        start();

        while (human.getDecision() != END_DECISION) {
            fight();
            result();

            if (human.getDecision() == RESTART_DECISION) {
                restart();
            }
        }

        end();
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.chooseBalls();
    }

    public static void fight() {
        inputHumanBalls();
        compareBalls();
    }

    public static void inputHumanBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        human.chooseBalls();
    }

    public static void compareBalls() {
        strikeCount = 0;
        ballCount = 0;

        for (int i = 0; i < BALLS_SIZE; i++) {
            int computerBall = computer.getBall(i);
            int humanBall = human.getBall(i);

            if (computerBall == humanBall) {
                strikeCount++;
            } else if (computer.getBalls().contains(humanBall)) {
                ballCount++;
            }
        }
    }

    public static void result() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            stop();
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public static void stop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        human.decideGameRestart();
    }

    public static void restart() {
        computer.chooseBalls();
        human.clearDecision();
    }

    public static void end() {
        human.clearDecision();
    }
}
