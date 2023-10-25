package baseball.domain.convert;

import static baseball.domain.Referee.*;

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
        if(referee.getStrikeScore() == ZERO_COUNT){
            return new StringBuilder().append(referee.getBallScore())
                .append("볼");
        }

        if(referee.getBallScore()== ZERO_COUNT){
            return new StringBuilder().append(referee.getStrikeScore())
                .append("스트라이크");
        }

        return new StringBuilder().append(referee.getBallScore())
            .append("볼 ")
            .append(referee.getStrikeScore())
            .append("스트라이크");
    }
}