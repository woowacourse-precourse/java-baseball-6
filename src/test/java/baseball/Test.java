package baseball;

import baseball.utility.InputDataExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class Test {
    public static void main(String[] args) {
        System.out.print("값 입력 : ");
        InputDataExceptionHandler.validateNumbers(Console.readLine());
        System.out.println("입력 검증 완료");
    }
}
