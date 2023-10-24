package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Again {
    public int again() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("1 입력 시 게임을 재시작합니다.\n" +
                "2 입력 시 프로그램이 종료됩니다.");
        char answer = Console.readLine().charAt(0);

        if(answer == '1') return 1;

        return 2;
    }
}
