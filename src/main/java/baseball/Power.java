package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Power {
    static int userChoice(int strike, int power) {
        if (strike == 3) {
            //게임 종료 -> 재시작 여부 확인
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


            try {
                int input = Integer.parseInt(Console.readLine());


                if (input == 1)
                    power = 1;
                else if (input == 2) {
                    power = 2;
                } else
                    throw new IllegalArgumentException();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }


        }
        return power;
    }
}