package baseball.domain.convert;

import baseball.domain.Referee;
import java.util.stream.Stream;

public class BaseballConverter {

    public int[] convertNumberToArray(int number) {
        return Stream.of(String
                .valueOf(number)
                .split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
    }

    public StringBuilder convertRefereeToScoreTextView(Referee referee){
        if(referee.getStrikeScore() == 0){
            return new StringBuilder().append(referee.getBallScore())
                .append("볼");
        }

        if(referee.getBallScore()== 0){
            return new StringBuilder().append(referee.getStrikeScore())
                .append("스트라이크");
        }

        return new StringBuilder().append(referee.getBallScore())
            .append("볼 ")
            .append(referee.getStrikeScore())
            .append("스트라이크");
    }
}