package baseball;

import camp.nextstep.edu.missionutils.Console;
public class PlayerNumInput {
    public static String PlayerNumInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        IllegalException.illegalInput(input);
//        try {
//            int a = Integer.parseInt(input);
//        }catch (IllegalArgumentException e){
//            return "Wrong";
//        }

        return input;
    }
}
