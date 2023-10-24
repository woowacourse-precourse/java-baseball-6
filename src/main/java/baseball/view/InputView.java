package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class InputView {
    public String next() {
        return Console.readLine();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public ArrayList<Integer> nextIntArray() {
        String input = next();

        ArrayList<Integer> results = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            results.add(input.charAt(i) - '0');
        }
        return results;
    }
}