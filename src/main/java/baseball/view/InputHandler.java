package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public int insertIntNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        return Integer.parseInt(inputString);
    }

}
