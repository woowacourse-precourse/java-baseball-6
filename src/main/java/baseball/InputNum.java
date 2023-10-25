package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
public class InputNum {
    public List<Integer> getInputNum() {
        List<Integer> userNum = new ArrayList<>();
        boolean reInput = false;
        while (!reInput) {
            try {
                System.out.print("숫자를 입력해주세요: ");
                String inputNum = Console.readLine();
                exception_input(inputNum);

                for (String one : inputNum.split("")) {
                    userNum.add(Integer.parseInt(one));
                }
                System.out.println(userNum);
                reInput = true;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }
        }
        return userNum;
    }

    public void exception_input(String inputNum) {
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
}



