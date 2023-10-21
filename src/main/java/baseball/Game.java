package baseball;


public class Game {
    private boolean end;
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

    }

    public void endGame() {

    }
}
