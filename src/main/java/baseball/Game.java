package baseball;


public class Game {
    private boolean end;
    private String input;
    private Computer computer;
    private User user;

    Game() {
        end = false;
        computer = new Computer();
        user = new User();
    }

    public void doGame() {
        do {
            startGame();
            inGame();
            endGame();
        } while (!end);
    }

    public void startGame() {
        computer.printMsg("숫자 야구 게임을 시작합니다.\n");
        computer.makeAnswer();
    }

    public void inGame() {
        do {
            computer.printMsg("숫자를 입력해주세요 : ");
            input = user.getGameInput();
            computer.makeResult();
        } while (!computer.checkAnswer());
    }

    public void endGame() {
        computer.printMsg("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        input = user.getGameEndInput();
        if (input.equals("2"))
            end = true;
    }
}
