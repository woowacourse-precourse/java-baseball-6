package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String In_Fir(){

        String input;
        input = Console.readLine();

        if(input.length() != 3){
            throw new IllegalArgumentException("3자리 숫자만 가능합니다.");
        }

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '1' || input.charAt(i) > '9'){
                throw new IllegalArgumentException("1부터 9까지만 입력해주세요.");
            }
        }

        return input;
    }

    public static String In_Sec(){

        String input;
        input = Console.readLine();

        if(input.length() > 1){
            throw new IllegalArgumentException("1 혹은 2만 입력하세요.");
        }

        if(input.charAt(0) != '1' && input.charAt(0) != '2'){
            throw new IllegalArgumentException("1 혹은 2만 입력하세요.");
        }

        return input;
    }
}
