package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

public class Player {
    ArrayList<Integer> tryNum;
    int no;

    public ArrayList<Integer> getTryNum() {
        return tryNum;
    }

    public int getNo() {
        return no;
    }

    public void getInput(int num) throws IllegalArgumentException {
        String str;
        tryNum = new ArrayList<>();

        do {
            str = readLine();
        } while ((str == null) || str.isBlank());

        // 정수가 아닌 값을 입력한 경우
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        // 숫자 길이 검사
        if (str.length() != num) {
            throw new IllegalArgumentException();
        }

        if (num == 3) {

            for (int i = 0; i < 3; i++) {
                int inputNumber = str.charAt(i) - '0';

                if (inputNumber == 0 ||                 // 0을 포함한 경우
                        tryNum.contains(inputNumber)) {   // 같은 숫자를 입력한 경우
                    throw new IllegalArgumentException();
                }

                tryNum.add(inputNumber);
            }

        } else if (num == 1) {
            no = Integer.parseInt(str);

            // 입력값이 1 또는 2가 아닌 경우
            if ((no != 1) && (no != 2)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
