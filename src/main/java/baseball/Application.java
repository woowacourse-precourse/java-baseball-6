package baseball;

public class Application {
    private static void checkStart(BaseBallGame bg, String num) {
        if (num.contentEquals("1")) {
            bg.start();
        }
    }

    private static void display() {
        String num = "1";
        BaseBallGame bg = new BaseBallGame();
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            checkStart(bg, num);
            if (num.contentEquals("2")) {
                break;
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            num = Util.getArgument();
        } while (true);
    }

    public static void main(String[] args) {
        display();
    }

}
