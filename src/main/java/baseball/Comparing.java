package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparing {
    int equalsNumber = 0;
    int equalsPosition = 0;
    public Result compareNumbers(String readLine, List<Integer> computer) {
        List<Integer> user = new ArrayList<>();

        generateUserNumbers(readLine, user);

        compareIndex(computer, user);

        return new Result(equalsNumber, equalsPosition);
    }

    private static void generateUserNumbers(String readLine, List<Integer> user) {
        for (int i = 0; i < readLine.length(); i++) {
            user.add(Character.getNumericValue(readLine.charAt(i)));
        }
    }

    private void compareIndex(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            int userIndex = user.get(i);
            int computerIndex = computer.get(i);

            countEqualsNumberAndPosition(computer, userIndex, computerIndex);
        }
    }

    private void countEqualsNumberAndPosition(List<Integer> computer, Integer userIndex, Integer computerIndex) {
        if (userIndex == computerIndex) {
            equalsPosition++;
        }
        if (computer.contains(userIndex)) {
            equalsNumber++;
        }
    }
}
