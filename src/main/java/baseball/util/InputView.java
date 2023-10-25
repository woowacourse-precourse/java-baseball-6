package baseball.util;

import baseball.service.GameResult;
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

    public static int askNewGame(int size, GameResult result) {

        if (result.getStrike() !=  size) {
            return  -1;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String rxNum = Console.readLine();
        Validator.isNumber(rxNum);
        return Integer.parseInt(rxNum);
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
