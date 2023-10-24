package baseball.model;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberComparator {


    //길이 및 중복성 검사
    public static void checkLength(List<String> input){

        if (input.size() > 3) {
            throw new IllegalArgumentException("입력된 숫자가 세자리 이상이다.");
        }

    }

    public static void checkRedundancy(List<String> input) {
        List<String> distinctList = input.stream().distinct().toList();

        if(input.size() > distinctList.size()) {
            throw new IllegalArgumentException("중복 입력된 숫자가 있다.");
        }
    }

    //입력값 유효성 검사
    public static int parseAndVaiidateInput(String s){

        try{
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 숫자가 int형이 아니다.");

        }
    }


    public static void compareNumber(List<Integer> computer, List<String> user){

        checkLength(user);
        checkRedundancy(user);

        int strike = 0, ball = 0;
        for (int i = 0; i < user.size(); i++) {
            int number = parseAndVaiidateInput(user.get(i));
            if (computer.get(i) == number) {
                strike++;
                continue;
            } else if (computer.contains(number)) {
                ball++;
            }
        }

    }
}
