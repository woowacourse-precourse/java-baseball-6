package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = Game.startNewGame();

        try {
            while (true) {

                Player player = Player.fromUserInput();
                String result = game.play(player.getPlayerNumbers());
                System.out.println(result);

                if (result.contains("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
