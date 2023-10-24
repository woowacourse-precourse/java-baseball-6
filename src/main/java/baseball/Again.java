package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.InputMismatchException;

public class Again {
    public boolean getAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean again = true;
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch(InputMismatchException ime) {
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
        if(input != 1 && input != 2)
            throw new IllegalArgumentException("1 과 2 중 입력하세요");
        if (input == 2) {
            again = false;
        }
        return again;
    }
}