package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Player player = new Player();
        Computer computer = new Computer();
        Game game = new Game(player, computer);
        game.start();
    }
}
