package baseball;

public class Application {

    static boolean gameOver = false;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            BaseBall baseBall = new BaseBall();
            gameOver = baseBall.start();

            if (gameOver) {
                break;
            }
        }
    }
}
