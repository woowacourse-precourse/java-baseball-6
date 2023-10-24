package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int state = 1;
        BaseBall baseBall = new BaseBall();

        while(state == 1) {
            baseBall.start();
            state = baseBall.restart();
        }
    }
}