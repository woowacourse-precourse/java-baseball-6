package baseball;

import java.util.List;

public class NumberCheck {

    public String check(List<Integer> computerNumbers, String userInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i) == Character.getNumericValue(userInput.charAt(i))) {
                strikes++;
            } else if (computerNumbers.contains(Character.getNumericValue(userInput.charAt(i)))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else if (strikes == 3) {
            return "3스트라이크";
        } else {
            String ans = "";

            if (balls > 0 && strikes > 0) {
                ans = balls + "볼 " + strikes + "스트라이크";
            }
            else if (strikes > 0) {
                ans = strikes + "스트라이크";
            }
            else {
                ans = balls + "볼";
            }

            return ans;
        }
    }
}