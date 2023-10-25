package baseball.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
public class InputView {

    public static String setUserNumber(){
        System.out.print("숫자를 입력해주세요. : ");
        return Console.readLine();
    }

    public static List<String> UserNumbertoList(){
        String userNumber = setUserNumber();
        return List.of(userNumber.split(""));

    }

    public static String restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return Console.readLine();
    }
}
