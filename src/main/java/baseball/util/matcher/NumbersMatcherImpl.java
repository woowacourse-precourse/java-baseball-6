package baseball.util.matcher;

import baseball.util.parser.MatchResultParser;

import java.util.List;

public class NumbersMatcherImpl implements NumbersMatcher {
    public NumbersMatcherImpl(MatchResultParser matchResultParser) {
        this.matchResultParser = matchResultParser;
    }

    private final MatchResultParser matchResultParser;

    @Override
    public String matches(List<Integer> randomNumbers, String inputNumbers) {
        int ballCount = 0;
        int strikeCount = 0;

        for ( int i = 0; i < inputNumbers.length(); i++ ) {
            Integer s = Integer.parseInt(inputNumbers.substring(i, i + 1));

            int index = randomNumbers.indexOf(s);

            if ( index == i ) {
                strikeCount++;
                continue;
            }
            if ( index != -1 )
                ballCount++;
        }

        return matchResultParser.parse(ballCount, strikeCount);
    }
}
