package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isFinished = false;

        while (!isFinished) {
            Game game = new Game();
            while (!game.isSolved()) {
                game.getUserInt();
                game.printResult();
            }
            game.getUserChoice();
            isFinished = game.isFinished();
        }
    }
}
