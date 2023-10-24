package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 0. 변수 선언
        String input_number = "";
        String game_continue = "1";
        Computer computer = new Computer();

        // 2. 처리
        while (game_continue.equals("1")) {
            ArrayList<Integer> input = new ArrayList<>();

            // 1. 입력
            // Q. 입력값은 서로 다른 3개의 숫자라고 되어있는데, 입력 자체에서 숫자의 범위를 제한하지는 않는 건지 궁금합니다.
            System.out.print("숫자를 입력해주세요 : ");

            input_number = Console.readLine();

            if (input_number.length() != 3) {
                throw new IllegalArgumentException();
            }

            input.add(input_number.charAt(0) - 48);
            input.add(input_number.charAt(1) - 48);
            input.add(input_number.charAt(2) - 48);

            // 3. 결과 출력
            if (computer.check_input(input)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                game_continue = Console.readLine();

                if (!(game_continue.equals("1") || game_continue.equals("2"))) {
                    throw new IllegalArgumentException();
                }
                if (game_continue.equals("1")) {
                    computer = new Computer();
                }
            }

        }
    }
}
