package baseball.users;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private List<Integer> inningNumbers = new ArrayList<>();

    public abstract void setInningNumbers();

    public void clearInningNumbers() {
        inningNumbers.clear();
    }

    public int sizeOfInningNumbers() {
        return inningNumbers.size();
    }

    public void addInningNumbers(int number) {
        inningNumbers.add(number);
    }

    public int getInningNumbers(int index) {
        return inningNumbers.get(index);
    }

    public boolean containsInningNumbers(int number) {
        return inningNumbers.contains(number);
    }

    public int[] playsWith(User user) {
        int[] gameResult = new int[2];
        for (int i = 0; i < inningNumbers.size(); i++) {
            int number = user.getInningNumbers(i);
            if (inningNumbers.get(i) == number) {
                gameResult[1]++;
            } else if (inningNumbers.contains(number)) {
                gameResult[0]++;
            }
        }
        return gameResult;
    }
}
