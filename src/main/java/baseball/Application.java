package baseball;

import static baseball.Playing_Game.playingGame;
import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        int[] index;

        //게임이 끝난 후 사용자가 계속 게임을 할 지에 대한 변수
        int continue_game;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = new ArrayList<>();
            index = new int[10];
            set_Random_numbers(index, computer);

            playingGame(computer, index);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            continue_game = Integer.parseInt(readLine());

            if (continue_game == 1) {
                continue;
            }
            if (continue_game == 2) {
                break;
            }
        }
    }

    private static void set_Random_numbers(int[] index, List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                index[randomNumber] = computer.size();
            }
        }
    }
}
