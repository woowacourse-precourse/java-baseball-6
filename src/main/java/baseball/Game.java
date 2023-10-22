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
            end = true;
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

    }
}
