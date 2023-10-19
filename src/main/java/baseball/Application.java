package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static final int DIGIT = 3;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        List<Integer> pickedList = selectDigitNumbers(DIGIT);
        String userInput = tryAnswer();
    }

    public static List<Integer> selectDigitNumbers(int digit){
        List<Integer> pickedList = new ArrayList<>();
        while(pickedList.size() < digit){
            int pickedRandomNum = Randoms.pickNumberInRange(1, 9);
            if(pickedList.contains(pickedRandomNum)) continue;
            pickedList.add(pickedRandomNum);
        }
        return pickedList;
    }

    public static String tryAnswer(){
        System.out.println("세개의 숫자를 입력해주세요. : ");
        String userInput = Console.readLine();
        try {
            validateInput(userInput);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        return userInput;
    }
    public static void validateInput(String userInput) throws Exception {
        // 3자리 수가 아니거나, 숫자가 아니거나, 동일한 수가 있으면 에러
        boolean isDuplicate = Arrays.stream(userInput.split("")).distinct().count() != userInput.split("").length;
        boolean hasZero = userInput.contains("0");
        if(userInput.length() != 3 || isDuplicate || hasZero) throw new Exception();
    }
}
