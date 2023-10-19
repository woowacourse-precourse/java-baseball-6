package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 0. 변수 선언
        Scanner sc = new Scanner(System.in);
        int input_number = 0;
        int game_continue = 1;

        // 2. 처리
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();

        while(game_continue == 1) {
            ArrayList<Integer> input = new ArrayList<>();

            // 1. 입력
            // Q. 입력값은 서로 다른 3개의 숫자라고 되어있는데, 입력 자체에서 숫자의 범위를 제한하지는 않는 건지 궁금합니다.
            System.out.print("숫자를 입력해주세요 : ");
            try {
                input_number = sc.nextInt();
                if((input_number) / 100 >= 10) throw new IllegalArgumentException();
                if((input_number) / 100 < 1) throw new IllegalArgumentException();

                input.add(input_number / 100);
                input.add((input_number / 10) % 10);
                input.add(input_number % 10);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("입력값이 잘못되었습니다.");
                return;
            }

            if(computer.check_input(input)){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                try {
                    game_continue = sc.nextInt();

                    if(game_continue != 1 && game_continue != 2) throw new IllegalArgumentException();
                    if(game_continue == 1) {
                        System.out.println("숫자 야구 게임을 시작합니다.");
                        computer = new Computer();
                    }

                } catch (IllegalArgumentException illegalArgumentException){
                    System.out.println("입력값이 잘못되었습니다.");
                    return;
                }
            }

        }
    }
}
