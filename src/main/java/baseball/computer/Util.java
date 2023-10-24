package baseball.computer;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static void checkUserNumSize(String UserNum) {
        if (UserNum.length() != 3) {
            throw new IllegalArgumentException("프로그램을 종료합니다.");
        }
    }


    public static void checkUserEndNum(int choice) {
        if (choice > 2 || choice < 1) {
            throw new IllegalArgumentException("프로그램을 종료합니다.");
        }
    }


    public static void checkUserNumSame(String UserNum) {
        for (int i = 1; i < 3; i++) {
            if (UserNum.charAt(i - 1) == UserNum.charAt(i)) {
                throw new IllegalArgumentException("프로그램을 종료합니다.");
            }
        }
    }

    public static String getUserNum() {
        String UserNum = Console.readLine();
        checkUserNumSize(UserNum);
        checkUserNumSame(UserNum);
        return UserNum;
    }

    public static String getComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        String ComputerNum = "";
        for (int i = 0; i < 3; i++) {
            ComputerNum += computer.get(i);
        }
        return ComputerNum;
    }
}
