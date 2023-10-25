package baseball;

import java.util.HashMap;
import java.util.Map;

public class Comparator {

    public Map<String, Integer> getResult(String computer, String user) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i=0; i<user.length(); i++) {
            strikeCnt = getStrikeCnt(computer, user);
            ballCnt = getBallCnt(computer, user) - strikeCnt;
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("strike", strikeCnt);
        map.put("ball", ballCnt);

        return map;
    }

    private int getStrikeCnt(String computer, String user) {
        int strikeCnt = 0;

        for (int i=0; i<computer.length(); i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    private int getBallCnt(String computer, String user) {
        int ballCnt = 0;

        for (int i=0; i<computer.length(); i++) {
            for (int j=0; j<user.length(); j++) {
                if (computer.charAt(i) == user.charAt(j)) {
                    ballCnt++;
                    break;
                }
            }
        }

        return ballCnt;
    }
}
