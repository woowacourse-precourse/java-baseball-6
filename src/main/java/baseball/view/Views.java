package baseball.view;
import camp.nextstep.edu.missionutils.Console;

public class Views {

    private static final int OUT_COUNT = 3;

    public static String inputNumber() {
        String input = Console.readLine();
        return input;
    }

    public static void printQuestion() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static void printIntro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printStrikeBallCount(int strike,int ball) {
        System.out.printf("%d볼 %d스트라이크\n",ball,strike);
    }

    public static void printStrike(int strike) {
        System.out.printf("%d스트라이크\n" , strike);
    }

    public static void printBall(int ball) {
        System.out.printf("%d볼\n" , ball);
    }

    public static void printOut() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n",OUT_COUNT);
    }
    public static void printWantRegame() {
        System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
