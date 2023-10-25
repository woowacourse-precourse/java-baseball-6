package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    List<Integer> userNumbers;

    public void setUserNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        //3자리, 중복, 0여부 확인
        Pattern pattern = Pattern.compile("^(?!.*(\\d).*\\1)[1-9]{3}$");
        Matcher matcher = pattern.matcher(inputString);

        int inputNumber = Integer.parseInt(inputString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        List<Integer> generatedNumbers = new ArrayList<>();
        generatedNumbers.add(inputNumber / 100);
        generatedNumbers.add(inputNumber / 10 % 10);
        generatedNumbers.add(inputNumber % 10);

        this.userNumbers = generatedNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
