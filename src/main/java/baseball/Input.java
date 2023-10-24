package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public List<Integer> numberInput() {
        String stringNum = readLine();

        //예외 처리 - 3자 이상일 경우
        if (3 < stringNum.length()) {
            throw new IllegalArgumentException();
        }
        //예외 처리 - 0이 포함 될 경우
        if (stringNum.contains("0")) {
            throw new IllegalArgumentException();
        }


        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < stringNum.length(); i++) {
            char charDigit = stringNum.charAt(i);

            if (Character.isDigit(charDigit)) {
                int digit = Character.getNumericValue(charDigit);
                integerList.add(digit);
            }
            else{ //예외 처리 - 정수 아닌 문자가 섞여있을 경우
                throw new IllegalArgumentException();
            }
        }

        //예외 처리 - 중복된 숫자가 있을 경우
        for (int i = 0; i < integerList.size(); i++) {
            for (int j = i + 1; j < integerList.size(); j++) {
                if(Objects.equals(integerList.get(i), integerList.get(j))) throw new IllegalArgumentException();
            }
        }

        return integerList;
    }

    public int statusInput() {
        String inputNum = readLine();

        //예외 처리
        if (!(Objects.equals(inputNum, "1") || Objects.equals(inputNum, "2"))) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputNum);
    }
}
