package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameProcess game = new GameProcess();

        while (true) {
            game.changeUserAnswer();
            if (game.determine()) {
                if (game.endGame()) {
                    break;
                }
                game.deleteValues();
                game.changeComAnswer();
            }
        }
    }
}
