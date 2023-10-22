package baseball;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private final List<Integer> inputs;

    Input(String s) throws IllegalArgumentException {
        this.inputs = new ArrayList<>();

        for (char c : s.toCharArray()) {
            inputs.add(Character.getNumericValue(c));
        }
        if (inputs.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    List<Integer> getNumber() {
        return inputs;
    }

    static int isEnd(String d) {
        int returnNumber = 0;
        try {
            int i = Integer.parseInt(d);
            if (i == 1) {
                returnNumber = 1;
            } else if (i == 2) {
                System.out.println("게임이 종료 되었습니다.");
            } else {
                throw new IllegalArgumentException();
            }
            return returnNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}