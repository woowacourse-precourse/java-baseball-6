package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Baseball_Input {
    private static List<Integer> userInput;

    public static void setUserInput(){
        userInput = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        try {

            int inputStrToInt = Integer.parseInt(inputString);

            //세 자리수 입력 판단
            if(inputStrToInt < 123 || inputStrToInt > 987 ){
                IllegalArgumentException e = new IllegalArgumentException("IllegalArgumentException");
                throw e;
            }

            // 서로 다른 수인지 판단
            for(int i=2; i>=0; i--){
                int newAdder = inputStrToInt /= Math.pow(10,i) ;
                if(userInput.contains(newAdder)){
                    IllegalArgumentException e = new IllegalArgumentException("IllegalArgumentException");
                    throw e;
                }
                userInput.add(newAdder);
            }

        }catch(IllegalArgumentException e){
            throw e;
        }

    }
}
