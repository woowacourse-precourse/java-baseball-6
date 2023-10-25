package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human {

    private List<Integer> Number = new ArrayList<>(Arrays.asList(0, 0, 0));

    public void setNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateInput(input);

    }

    public void validateInput(String input) {
        List<Integer> parseInput = new ArrayList<>(Arrays.asList(0, 0, 0));
        // 1. Invalid Length
        if (input.length() != 3) {
            throw new IllegalArgumentException("Length 가 3이 아님.");
        }

        // 2. Invalid type ( ex. 1a2, 112

        for (int charIdx = 0; charIdx < input.length(); charIdx++) {

            int parseInt;
            try {
                parseInt = Integer.parseInt(String.valueOf(input.charAt(charIdx)));
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid Type 발생: (ex. 1a2)");
            }

            if (parseInt == 0) {
                throw new IllegalArgumentException("Input 에 0을 포함하고있음.");
            }
            if (parseInput.contains(parseInt)) {
                throw new IllegalArgumentException("Input 중 중복된 값이 있음. ex) 113, 112, 111");
            }

            parseInput.set(charIdx, parseInt);
        }

        // contains 0

        Number = parseInput;
    }

    public List<Integer> getNumber() {
        return Number;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Number=" + Number +
                '}';
    }


}
