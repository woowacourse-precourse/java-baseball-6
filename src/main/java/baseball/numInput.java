package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class numInput {

    List<Integer> userNum() {
        List<Integer> userInput = new ArrayList<>();
        String st = Console.readLine();
        String[] divide = st.split("");

        for (int i = 0; i < 3; i++) {
            userInput.add(Integer.parseInt(divide[i]));
        }
        return userInput;
    }
}
