package baseball.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void outputGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void outputStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    public static void outputMatch(Map<String, Integer> matchedResultInfo) {
        System.out.println(makeResultString(matchedResultInfo));
    }

    private static String makeResultString(Map<String, Integer> matchedResultInfo) {
        List<String> matchArr = new ArrayList<String>();
        if(matchedResultInfo.size() == 0) matchArr.add("낫싱");

        for(String key : matchedResultInfo.keySet()) {
            matchArr.add(matchedResultInfo.get(key) + key);
        }

        return String.join(" ", matchArr);
    }
}
