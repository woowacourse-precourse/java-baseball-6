package baseball.view;
//사용자로부터 숫자입력받기, 게임 종료/재시작 여부
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public static String GetNum(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String AskForRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
