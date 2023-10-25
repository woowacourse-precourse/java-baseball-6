package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        int[] numbers = new int[3];
        int input = Integer.parseInt(Console.readLine());

        numbers[0] = input / 100;       // 백의 자리 수
        numbers[1] = (input / 10) % 10; // 십의 자리 수
        numbers[2] = input % 10% 10;    // 일의 자리 수
        



    }
}
