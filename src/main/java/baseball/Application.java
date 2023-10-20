package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int execInput = 1;
        while (execInput == 1){
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            execInput = Integer.parseInt(Console.readLine());

            if (execInput == 1 || execInput == 2){
                Exception IllegalArgumentException;
            }

        }
    }
}
