package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballInput {
    private static List<Integer> userInput;
    private static int restartNum;

    private BaseballInput(){

    }

    public static List<Integer> getUserInput() {
        return userInput;
    }

    public static void decideBoundIllegalArgumentException(int num){
        if (num < 123 || num > 987 ) {
            IllegalArgumentException e = new IllegalArgumentException("IllegalArgumentException");
            throw e;
        }
    }

    public static void decideContainsIllegalArgumentException(boolean isit){
        if (isit) {
            IllegalArgumentException e = new IllegalArgumentException("IllegalArgumentException");
            throw e;
        }
    }


    public static void setUserInput() {
        userInput = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        try {
            int inputStrToInt = Integer.parseInt(inputString);

            //세 자리수 입력 판단
            decideBoundIllegalArgumentException(inputStrToInt);

            // 서로 다른 수인지 판단
            for(int i=2; i>=0; i--) {
                int newAdder = inputStrToInt / (int)Math.pow(10,i) ;
                inputStrToInt %= (int)Math.pow(10,i) ;
                decideContainsIllegalArgumentException(userInput.contains(newAdder));
                userInput.add(newAdder);
            }

        } catch(IllegalArgumentException e) {
            throw e;
        }

    }

    public static int getRestartNum() {
        return restartNum;
    }

    public static void setRestartNum() {

        String inputString = Console.readLine();
        try {

            int inputStrToInt = Integer.parseInt(inputString);

            if (inputStrToInt == 1) {
                restartNum = 1;
                return;
            }
            if (inputStrToInt == 2) {
                restartNum = 2;
                return;
            }

            // 1과 2 이외는 에러처리
            IllegalArgumentException e = new IllegalArgumentException("IllegalArgumentException");
            throw e;

        } catch(IllegalArgumentException e) {
            throw e;
        }
    }
}
