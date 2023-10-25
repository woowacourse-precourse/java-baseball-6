package baseball;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> userNum;

    public List<Integer> getUserNum(){
        return userNum;
    }

    public void createUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNum = convertStringToList(input);
        validateInput(inputNum);
        userNum = inputNum;
    }

    public List<Integer> convertStringToList(String input) {
        List<Integer> num;
        try {
            num = Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed().toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자여야 합니다.");
        }
        return num;
    }

    public void validateInput(List<Integer> inputNum) {
        validateRangeForAll(inputNum);
        validateSize(inputNum);
        validateDuplication(inputNum);
    }

    public void validateDuplication(List<Integer> inputNum) {
        if (inputNum.size() != inputNum.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    public void validateRangeForAll(List<Integer> inputNum) {
        for (int elem : inputNum) {
            validateRange(elem);
        }
    }

    public void validateRange(int num) {
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("숫자는 1~9범위이여야 합니다.");
        }
    }

    public void validateSize(List<Integer> inputNum) {
        if (inputNum.size() != 3) {
            throw new IllegalArgumentException("3자리 수 숫자여야 합니다.");
        }
    }
}
