package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class numInput {

    List<Integer> userNum() throws IllegalArgumentException {
        List<Integer> userInput = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String st = Console.readLine();
        String[] divide = st.split("");
        if (divide.length != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            userInput.add(Integer.parseInt(divide[i]));
        }
        return userInput;
    }
}