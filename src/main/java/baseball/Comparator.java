package baseball;

import java.util.HashMap;
import java.util.Map;

public class Comparator {

    public Map<String, Integer> getResult(String computer, String user) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i=0; i<user.length(); i++) {
            for (int j=0; j<computer.length(); j++) {
                if (user.charAt(i) == computer.charAt(j)) {
                    if (i == j) {
                        strikeCnt++;
                    } else {
                        ballCnt++;
                    }
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("strike", strikeCnt);
        map.put("ball", ballCnt);

        return map;
    }
}
