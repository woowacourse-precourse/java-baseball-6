package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int inputData(){
        return Integer.parseInt(Console.readLine());
    }

    public static int numberSuggestion() {
        System.out.print("숫자를 입력해주세요 : ");
        return inputData();
    }

    public static int retryOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return inputData();
    }
}
