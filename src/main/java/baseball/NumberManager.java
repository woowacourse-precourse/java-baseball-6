package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {
    private final static int NUMBER_LENGTH = 3;

    public List<Integer> createRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public List<Integer> receiveUserNumber() {
        String number = " ";
        System.out.print("숫자를 입력해주세요 : ");
        number = readLine();
        isVaildNumber(number);
        return convertStringToList(number);

    }

    private void isVaildNumber(String number) {
        if (number.length() != NUMBER_LENGTH)
            throw new IllegalArgumentException("숫자의 길이를 위반하였습니다.");
        if (number.contains("0"))
            throw new IllegalArgumentException("0이 포함되었습니다.");
        if (number.charAt(0) == number.charAt(1)
                || number.charAt(0) == number.charAt(2)
                || number.charAt(1) == number.charAt(2)) {
            throw new IllegalArgumentException("같은 수가 포함 되어 있습니다.");
        }
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (number.charAt(i) < '1' || number.charAt(i) > '9')
                throw new IllegalArgumentException("1~9 이외의 숫자가 포함되었습니다.");
        }
    }

    private List<Integer> convertStringToList(String number) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            numberList.add(number.charAt(i) - '0');
        }
        return numberList;
    }

    public String readLine() {
        String str = Console.readLine();
        if (str != null)
            return str;
        throw new IllegalArgumentException("입력이 NULL입니다.");

    }

}
