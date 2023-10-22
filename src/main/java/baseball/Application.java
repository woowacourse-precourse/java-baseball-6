package baseball;

public class Application {
    public static void main(String[] args) {
        String startPhrase = "숫자 야구 게임을 시작합니다.";
        System.out.println(startPhrase);

        boolean isFinished = false;

        while (!isFinished) {
            try {
                Game game = new Game();
                while (!game.isSolved()) {
                    game.getUserInt();
                    game.printResult();
                }
                game.getUserChoice();
                isFinished = game.isFinished();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                break;
            }
        }
    }
}
