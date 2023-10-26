package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparing {
    int strike = 0;
    int ball = 0;
    public Result compareNumbers(String readLine, List<Integer> computer) {
        List<Integer> user = new ArrayList<>();

        generateUserNumbers(readLine, user);

        compareIndex(computer, user);

        return new Result(strike, ball);
    }

    private static void generateUserNumbers(String readLine, List<Integer> user) {
        for (int i = 0; i < readLine.length(); i++) {
            user.add(Character.getNumericValue(readLine.charAt(i)));
        }
    }

    private void compareIndex(List<Integer> computer, List<Integer> user) {

        for (int i = 0; i < user.size(); i++) {
            countResults(computer, user, i);
        }
    }

    private void countResults(List<Integer> computer, List<Integer> user, int i) {
        int userIndex = user.get(i);
        int computerIndex = computer.get(i);

        if (userIndex == computerIndex) {
            strike++;
        }
        if (userIndex != computerIndex && computer.contains(userIndex)) {
            ball++;
        }
    }
}
