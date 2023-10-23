package game;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static Validation err_check = new Validation();
    public String input;

    public boolean InputNum() {
        System.out.print("숫자를 입력해주세요: ");
        String num = Console.readLine();
        if(err_check.validation_check(num)){
            input = num;
            return true;
        }
        return false;
    }
}
