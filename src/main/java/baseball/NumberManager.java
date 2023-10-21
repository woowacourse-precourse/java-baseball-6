package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberManager {
    private final static int LENGTH = 3;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public List<Integer> createRandomNumber() {
        List<Integer> number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public List<Integer> receiveNumber() {
        String number = "";
        System.out.print("숫자를 입력해주세요 : ");
        try {
            number = br.readLine();
            isVaildNumber(number);
            return convertToList(number); 
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("입력을 읽을 수 없습니다.");
        }
    }

    public void isVaildNumber(String number) {
        if (number.length() != LENGTH)
            throw new IllegalArgumentException("숫자의 길이를 위반하였습니다.");
        if (number.contains("0"))
            throw new IllegalArgumentException("0이 포함되었습니다.");
        if (number.charAt(0)==number.charAt(1) || number.charAt(0)==number.charAt(2) || number.charAt(1)==number.charAt(2)){
            throw new IllegalArgumentException("같은 수가 포함 되어 있습니다.");
        }
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) < '1' || number.charAt(i) > '9')
                throw new IllegalArgumentException("1~9 이외의 숫자가 포함되었습니다.");
        }
    }

    public List<Integer> convertToList(String number) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            numberList.add(number.charAt(i) - '0');
        }
        return numberList;
    }

}
