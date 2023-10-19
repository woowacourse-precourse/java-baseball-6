package baseball;

class Game {
    // 동작 순서
    // 1. 게임이 시작하고, 컴퓨터가 임의의 수를 선택한다.
    public void gameStart() {

    }

    // 2. 입력을 통해 컴퓨터의 수를 맞춘다.
    public void guessNumber() {

    }
    // 3. 모두 맞히면 게임이 종료된다.
    public void endGame() {

    }
    // 4. 다시 시작할건지 완전 종료할건지 선택한다.
    public boolean restart() {
        return false;
    }
    // 예외. 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 종료한다.
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.gameStart();
    }
}
