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

    public void startGame() {
        computer.printMsg("숫자 야구 게임을 시작합니다.\n");
        computer.makeAnswer();
    }

    public void inGame() {
        do {
            computer.printMsg("숫자를 입력해주세요 : ");
            input = user.getInput();
        } while (!computer.checkAnswer(input));
    }

    public void endGame() {
        computer.printMsg("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        input = user.getQuitInput();
        if (input.equals("2"))
            quit = true;
    }
}
