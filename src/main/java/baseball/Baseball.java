package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.Arrays;


public class Baseball {
    public static void play() {
        String targetNumber = GenerateRandomeNumber.generateNumber();
        while (true) {
            System.out.println("숫자를 입력해주세요 : "); 

            String input = Console.readLine();

            Validate.validateInput(input);

            if (input.equalsIgnoreCase(targetNumber)) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"); 
                break;
            }
            System.out.println(outputOfJudgment(targetNumber, input));
        }
    }

    public static String combineStrings(String target, String input) {
        return target + input;
    }

    public static int stringLength(String str) {
        return str.length();
    }

    public static String[] stringSplitToCharactersArray(String str) {
        return str.split("");
    }

    public static Set<String> arrayToSet(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));
        return set;
    }

    public static int sizeOfSet(Set<String> set) {
        return set.size();
    }

    public static int countTwoStringSame(String[] strArray1, String[] strArray2) {
        return (int) IntStream.range(0, strArray1.length)
                .filter(i -> strArray1[i].equals(strArray2[i]))
                .count();
    }

    public static int twoNumbersLength(String target, String input) {
        return stringLength(combineStrings(target, input));
    }

    public static int duplicateRemovedCombinedTwoNumbersSize(String target, String input) {
        return sizeOfSet(arrayToSet(stringSplitToCharactersArray(combineStrings(target, input))));
    }

    public static int strikes(String target, String input) {
        return countTwoStringSame(stringSplitToCharactersArray(target), stringSplitToCharactersArray(input));
    }

    public static int balls(String target, String input){
        return twoNumbersLength(target, input) - duplicateRemovedCombinedTwoNumbersSize(target, input) - strikes(target, input);
    }

    public static String nothing() {
        return "낫싱";
    }

    public static StringBuilder outputOfJudgment(String target, String input) {
        StringBuilder builder = new StringBuilder();
        int strikesCount = strikes(target,input);
        int ballCount = balls(target,input);
        if (ballCount == 0 && strikesCount == 0) {
            builder.append(nothing());
        }
        if (ballCount != 0) {
            builder.append(String.format("%d볼", ballCount));
        }
        if (ballCount != 0 && strikesCount != 0) {
            builder.append(" ");
        }
        if (strikesCount !=0) {
            builder.append(String.format("%d스트라이크", strikesCount));
        }
        return builder;
    }
}



