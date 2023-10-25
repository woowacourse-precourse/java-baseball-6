package baseball.gameRule;

import java.util.*;

public class GameRule {
    ArrayList<String> check = new ArrayList<>();
    private String computer;
    private String user;

    public GameRule(String computerNumber, String userNumber) {
        computer = computerNumber;
        user = userNumber;
    }

    public int isStrike() {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                cnt += 1;
                check.add(String.valueOf(computer.charAt(i)));
            }
        }
        return cnt;
    }

    public int isBall() {
        int cnt = 0;
        String[] computerArr = computer.split("");
        String[] userArr = user.split("");

        Set<String> computerSet = new HashSet<>(Arrays.asList(computerArr));
        Set<String> userSet = new HashSet<>(Arrays.asList(userArr));

        computerSet.retainAll(userSet);

        if (computerSet.isEmpty()) {
            return cnt;
        }
        for (int i = 0; i < 3; i++) {
            if (!check.contains(userArr[i]) && computerSet.contains(userArr[i])) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
