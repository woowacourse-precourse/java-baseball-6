package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    public Player() {}

    public List<Integer> setNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String element = Console.readLine();
        if (!validatePlayerNumber(element)) {
            throw new IllegalArgumentException();
        }
        System.out.println(element);
        String[] stringNumber = element.split("");
        for (String number : stringNumber) {
            playerNumber.add(Integer.parseInt(number));
        }
        return playerNumber;
    }

    // 사용자가 입력한 숫자, 유효성 검증
    public Boolean validatePlayerNumber(String number) {
        String threeNumberRegex = "^(?!.*(\\d).*\\1)\\d{3}$";
        Pattern pattern = Pattern.compile(threeNumberRegex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
