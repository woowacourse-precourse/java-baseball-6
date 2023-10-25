package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        int pick_num_min = 1;
        int pick_num_max = 9;
        int pick_num_len = 3;

        System.out.println("숫자 야구 게임을 시작합니다.");
        Games games = new Games(pick_num_len, pick_num_min, pick_num_max);
        while (true) {
            games.baseball_game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input_num = Console.readLine();
            if (Objects.equals(input_num, "2")) {
                break;
            } else if (Objects.equals(input_num, "1")) {

            } else throw new IllegalArgumentException();
        }
    }
}
