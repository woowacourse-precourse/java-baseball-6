package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다!");
        while (true){
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            Game game = new Game(computer);
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                String player = Console.readLine();
                int player_number = Integer.parseInt(player);
                if (!game.check(player_number)) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");

                }

                if(game.playing(player_number)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String ch = Console.readLine();
            if(ch.equals("2"))
                break;
        }
    }
}
