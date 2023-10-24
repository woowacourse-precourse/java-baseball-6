package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputGame {
    public List<Integer> playerNum() {
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> playerNum = new ArrayList<>();
        String input = Console.readLine();

        for(String num : input.split("")) {
            playerNum.add(Integer.parseInt(num));
        }
        exceptionInput(input);

        return playerNum;
    }

    public void exceptionInput(String str) {
        if(str.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }

        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        if(!isNumeric) {
            throw new IllegalArgumentException("입력한 값이 숫자가 아님");
        }

        boolean isDuplication = false;
        for (char c : str.toCharArray()) {
            if (str.contains(String.valueOf(c))) {
                isDuplication = true;
            }
        }
        if(isDuplication) {
            throw new IllegalArgumentException("입력한 값에 중복된 숫자가 있음");
        }
    }

}
