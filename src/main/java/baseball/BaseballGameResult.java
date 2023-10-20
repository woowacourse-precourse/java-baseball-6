package baseball;

import java.util.List;

public class BaseballGameResult {


    private final long ballCount;
    private final long strikeCount;

    public BaseballGameResult(List<BaseballType> types) {
        this.ballCount = types.stream().filter(BaseballType.BALL::equals).count();
        this.strikeCount = types.stream().filter(BaseballType.STRIKE::equals).count();
    }

    public String makeResultText() {
        StringBuilder sb = new StringBuilder();

        if (ballCount != 0) {
            sb.append(ballCount + "볼");
        }

        if (strikeCount != 0) {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(strikeCount + "스트라이크");
        }

        if (sb.isEmpty()) {
            sb.append("낫싱");
        }

        sb.append('\n');

        return sb.toString();
    }

    public boolean isEnded() {
        if (strikeCount == 3) {
            return true;
        }

        return false;
    }
}
