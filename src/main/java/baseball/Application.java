package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import baseball.Modules;

public class Application {
    public static void main(String[] args) {
        int pick_num_min = 1;
        int pick_num_max = 9;
        int pick_num_len = 3;

        System.out.println("숫자 야구 게임을 시작합니다.");
        Games games = new Games(pick_num_min, pick_num_max, pick_num_len);
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
