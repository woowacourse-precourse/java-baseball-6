package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {


    public static List<Integer> receiveNums(int numSize) {
        System.out.println(numSize + "자리 숫자의 값을 입력해 주세요.");
        String rxNums = Console.readLine();

        Validator.checkRxNums(rxNums,numSize);
        return strToIntegerList(rxNums);
    }

    private static List<Integer> strToIntegerList(String rxNums) {
        List<Integer> intNumList = new ArrayList<>();
        for(int i =0; i < rxNums.length(); i++){
            char num = rxNums.charAt(i);
            intNumList.add(Character.getNumericValue(num));
        }
        return intNumList;
    }



}
