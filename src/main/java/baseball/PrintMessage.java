package baseball;

public class PrintMessage implements Rule {
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void input() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameOver() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", DIGIT_SIZE);
    }

    public static void regame() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", STATE_PLAY, STATE_TERMINATE);
    }
}
