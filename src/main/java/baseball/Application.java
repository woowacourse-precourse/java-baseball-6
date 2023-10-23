package baseball;

public class Application {
    // Player와 Computer를 멤버변수로 구현?
    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        try {
            game.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하셨습니다.");
        }

    }
}
