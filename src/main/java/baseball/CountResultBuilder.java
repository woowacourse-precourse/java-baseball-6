package baseball;

public class CountResultBuilder {

    private final String strikeBuilder = "스트라이크";
    private final String ballBuilder = "볼";
    private final String nothingBuilder = "낫싱";

    public String build(int strike, int ball) {
        StringBuilder stringBuilder = new StringBuilder();
        if (ball != 0) {
            stringBuilder.append(ball)
                    .append(ballBuilder);
            if (strike != 0) {
                stringBuilder.append(" ")
                        .append(strike)
                        .append(strikeBuilder);
            }
        } else if (strike != 0) {
            stringBuilder.append(strike)
                    .append(strikeBuilder);
        } else {
            stringBuilder.append(nothingBuilder);
        }
        return stringBuilder.toString();
    }
}
