package baseball;

import static baseball.Utilities.*;

public class BaseballRules {
    public static int twoNumbersLength(String target, String input) {
        return stringLength(combineStrings(target, input));
    }

    public static int duplicateRemovedCombinedTwoNumbersSize(String target, String input) {
        return sizeOfSet(arrayToSet(stringSplitToCharactersArray(combineStrings(target, input))));
    }

    public static int strikes(String target, String input) {
        return countTwoStringSame(stringSplitToCharactersArray(target), stringSplitToCharactersArray(input));
    }

    public static int ball(String target, String input){
        return twoNumbersLength(target, input) - duplicateRemovedCombinedTwoNumbersSize(target, input) - strikes(target, input);
    }

    public static String nothing() {
        return "낫싱";
    }

    public static StringBuilder outputOfJudgment(String target, String input) {
        StringBuilder builder = new StringBuilder();
        int strikesCount = strikes(target,input);
        int ballCount = ball(target,input);
        if (ballCount == 0 && strikesCount == 0) {
            builder.append(nothing());
        }
        if (ballCount != 0) {
            builder.append(String.format("%d볼", ball(target,input)));
        }
        if (ballCount != 0 && strikesCount != 0) {
            builder.append(" ");
        }
        if (strikesCount !=0) {
            builder.append(String.format("%d스트라이크", strikes(target,input)));
        }
        return builder;
    }
}