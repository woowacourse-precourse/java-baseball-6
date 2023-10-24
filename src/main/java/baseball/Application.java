package baseball;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        Gamer gamer = new Gamer();
        List<Integer> gamer_number;

    while(true) {
            gamer_number = gamer.receiveNumber();
            if(game.getResult(gamer_number)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = readLine();
                if(input.equals("1")) {
                    game = new Game();
                } else if(input.equals("2")) {
                    break;
                }
            }
        }
    }
}
