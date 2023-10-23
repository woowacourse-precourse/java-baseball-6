package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean finished = false;
        while (!finished) {
            Game game  = new Game(3);
            game.run();
            printRestartOrExit();
            finished = Player.selectRestartOrExit();
        }
    }

    private static void printRestartOrExit() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
