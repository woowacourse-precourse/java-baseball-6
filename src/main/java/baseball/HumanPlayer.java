package baseball;
 
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanPlayer implements Player {
    @Override
    public List<Integer> getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        return inputNumbers;
    }
}
