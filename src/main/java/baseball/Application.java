package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.loop();
    }

    void loop() {
        printStartMessage();
        do {
            Game game = new Game();
            game.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (readRestartIntent());
    }

    void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private boolean readRestartIntent() throws IllegalArgumentException {
        String inputRestart = Console.readLine();
        if (inputRestart.equals("1")) {
            return true;
        } else if (inputRestart.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}