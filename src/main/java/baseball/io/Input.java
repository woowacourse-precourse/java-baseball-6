package baseball.io;
import camp.nextstep.edu.missionutils.Console;


public class Input {

    private static final String Input_Message = "숫자를 입력해주세요 : ";
    public String readLine(){
        System.out.print(Input_Message);
        return Console.readLine();
    }
}

