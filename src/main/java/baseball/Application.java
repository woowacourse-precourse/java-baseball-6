package baseball;

public class Application {
    public static void main(String[] args) {
        GameProcess gameProcess = new GameProcess();
        System.out.println("숫자 야구 게임을 시작합니다.");

        gameProcess.process();
    }
}
