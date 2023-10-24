package view;

import java.util.List;

public class OutputView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public String OutputFormat(List<Integer> result) {
        StringBuilder sb = new StringBuilder(524);
        if (result.get(0) > 0) { // 볼
            sb.append(result.get(0) + BALL);
        }
        if (result.get(1) > 0) { //스트라이크
            sb.append(result.get(1) + STRIKE);
        }
        if (result.get(2) == 3) { //낫싱
            sb.append(NOTHING);
        }
        return sb.toString();
    }
}
