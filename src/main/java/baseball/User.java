package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    public static ArrayList<Integer> getNumber() {
        String userInput = Console.readLine();
        onlyNumCheck(userInput);
        lengthCheck(userInput);

        int inputNumInt = Integer.parseInt(userInput);
        int a = inputNumInt / 100;
        int b = inputNumInt / 10 % 10;
        int c = inputNumInt % 100 % 10;
        ArrayList<Integer> userInputArray = new ArrayList<>(Arrays.asList(a, b, c));

        duplicationCheck(userInputArray);
        return userInputArray;
    }


    private static void onlyNumCheck(String inputNum) {
        final Pattern compile = Pattern.compile("[0-9]+");
        final Matcher matcher = compile.matcher(inputNum);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
    private static void lengthCheck(String inputNum) {
        if (inputNum.length() > 3 || inputNum.length() < 3) {
            throw new IllegalArgumentException("길이가 4글자 이상 입니다.");
        }
    }

    private static void duplicationCheck(ArrayList<Integer> userInputArray) {
        List<Integer> errorCheck = new ArrayList<Integer>();
        for (int num : userInputArray) {
            if (!errorCheck.contains(num)) {
                errorCheck.add(num);
            } else {
                throw new IllegalArgumentException("중복된 숫자 발생");
            }
        }
    }

}
