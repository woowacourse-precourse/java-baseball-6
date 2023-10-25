package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private static final int length = 3;
    public static final String exit = "2";
    private static final String restart = "1";

    public List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        for (int i = 0; i < computer.size(); i++) {
            System.out.println(computer.get(i));
        }
        return computer;
    }


    public void validateInputNumber(String input) throws IllegalArgumentException{
        // 입력한 숫자의 길이가 3이 아닌 경우
        if (input.length() != length) {
            throw new IllegalArgumentException();
        }

        // 각 자리 수가 숫자가 아닌 경우
        // 각 자리 수가 1부터 9로 이루어지지 않은 경우
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) {
                throw new IllegalArgumentException();
            }else{
                if (Character.getNumericValue(arr[i]) < 1 || Character.getNumericValue(arr[i]) > 9) {
                    throw new IllegalArgumentException();
                }
            }

        }

        // 각 자리 수에 중복이 있는 경우
        int[] cntarr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int idx = Character.getNumericValue(arr[i]);
            cntarr[idx]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (cntarr[i]>1) throw new IllegalArgumentException();

        }
    }

    public void validateRetryNumber(String input) throws IllegalArgumentException {
        // 1 or 2
        // 한자리 수가 아닌 경우
        if (!input.equals(restart) && !input.equals(exit)) {
            throw new IllegalArgumentException();
        }
    }

}
