package baseball;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    String Input_Word = "숫자를 입력해주세요 :";


    public String InputNumber () {
        System.out.println(Input_Word);
        return Console.readLine();
    }

    public String Restart () {
        return Console.readLine();
    }

}
