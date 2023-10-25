package baseball.validate;

import baseball.domain.BaseBallGameRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidate extends BaseBallGameRule {

    public InputValidate() {

    }

    public List<Integer> numbersCheck(String givenInputs) {
        List<Integer> given = numbersFormat(Arrays.asList(givenInputs.split("")));
        sizeCheck(given);
        numbersRangeCheck(given);
        return given;
    }

    public void numbersRangeCheck(List<Integer> given) {
        for (Integer numberGiven  : given) {
            rangeCheck(numberGiven);
        }
    }

    public void rangeCheck(Integer numberGiven) {
        if(minValueOfBall > numberGiven) {
            throw new IllegalArgumentException("Error under range min value");
        }
        if(maxValueOfBall < numberGiven) {
            throw new IllegalArgumentException("Error over range max value");
        }
    }

    private void sizeCheck(List<Integer> given) {
        if (given.size() != maxNumberOfBallsAmount) {
            throw new IllegalArgumentException("Error for size : " + given.size());
        }
    }

    private List<Integer> numbersFormat(List<String> inputs) {
        try {
            return inputs.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("For input string :" + e);
        }
    }

    public static int singleNumberCheck(String givenInput) {
        Integer given = numberFormat(givenInput);
        gameRestartValueCheck(given);
        return given;
    }

    private static void gameRestartValueCheck(Integer given) {
        if (!(given == restartGameValue || given == endGameValue)) {
            throw new IllegalArgumentException("For input string :");
        }
    }

    private static Integer numberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("For input string :" + e);
        }

    }

}
