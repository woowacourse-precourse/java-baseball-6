package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean gameChoice = true;
        List<Integer> computerNum = new ArrayList<>();
        String gameString = "";
        // 컴퓨터 숫자를 생성함. 차후 메소드로 바꿀것
        while (computerNum.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(num)) {
                computerNum.add(num);
            }
        }
    }
}
