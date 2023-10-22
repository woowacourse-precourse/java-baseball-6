package baseball;


public class Game {
    private boolean quit;
    private String input;
    private Computer computer;
    private User user;

    Game() {
        quit = false;
        computer = new Computer();
        user = new User();
    }

    public void doGame() {
        do {
            startGame();
            inGame();
            endGame();
        } while (!quit);
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.makeAnswer();
    }

    private void inGame() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = user.getInput();
        } while (!computer.checkAnswer(input));
    }

    private void endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = user.getQuitInput();
        if (input.equals("2"))
            quit = true;
    }
}
