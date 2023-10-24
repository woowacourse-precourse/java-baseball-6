package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNum {
    public List<Integer> inputNum() {

        System.out.print("숫자를 입력하세요: ");

        // 입력값 받아서 각 자릿수로 분리
        int inputNum = Integer.parseInt(Console.readLine());
        int inputNum1 = inputNum / 100;
        int inputNum2 = (inputNum - inputNum1 * 100) / 10;
        int inputNum3 = inputNum - inputNum1 * 100 - inputNum2 * 10;

        if (inputNum >= 1000) {

            throw new IllegalArgumentException();

        }

        List<Integer> inputNumList = new ArrayList<>();

        inputNumList.add(inputNum1);
        inputNumList.add(inputNum2);
        inputNumList.add(inputNum3);

        return inputNumList;
    }

}
