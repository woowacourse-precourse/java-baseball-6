package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public static Boolean gameSwitch = true;

    public static void setGameSwitch(Boolean gameSwitch) {
        Referee.gameSwitch = gameSwitch;
    }

    public List<Integer> decideResult(List<Integer> computerBall, List<Integer> playerBall) {
        List<Integer> result = new ArrayList<>();
        // 값 조회할 때 리스트 vs 배열 vs 맵 중 뭐가 가장 빠를까?
        int ballCount = 0;
        int strikeCount = 0;

        // if문 중첩이 많은 거 같은데 수정할 수 있을까?
        for(int i = 0; i < playerBall.size(); i++) {
            int value = playerBall.get(i);
            if(computerBall.contains(value)) {
                if(computerBall.indexOf(value) != i) {
                    ballCount += 1;
                }
                if(computerBall.indexOf(value) == i) {
                    strikeCount += 1;
                }
            }
        }

        result.add(ballCount);
        result.add(strikeCount);

        return result;
    }
}
