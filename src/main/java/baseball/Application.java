package baseball;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // TODO : 한 게임이 종료되면 새 게임을 실행할지 묻기.

        System.out.println("숫자 야구 게임을 시작합니다.");
        run(); // 프로그램 시작

    }

    static public void run() {
        String input;
        int i = 0;
        do {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            //   Scanner sc = new Scanner(System.in);
            input = Console.readLine();
            i = Integer.parseInt(input);
            if (!(i == 1 || i == 2)) {
                throw new IllegalArgumentException("1또는 2만 입력할 수 있습니다.");
            }
        } while (i == 1);
    }

    static public void startGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) { // 컴퓨터가 지정한 숫자 3개
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            //    System.out.println("고른 숫자 : "+randomNumber);
            if (!computer.contains(randomNumber)) { // 중복되는 수를 없애기 위해서
                computer.add(randomNumber);
            }
        }
//        computer.add(7);
//        computer.add(1);
//        computer.add(3);

        Game game = new Game(computer);
        // todo : 컴퓨터의 수는 정해젔으니 이제 사용자의 수를 입력할 차례
        game.startGame();
    }


}
