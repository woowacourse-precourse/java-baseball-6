package baseball;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean wantExit = false;

        while (!wantExit) {
            GameProcess.gameStart();
            wantExit = GameProcess.askExitOrRestart();
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
