package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        List<Integer> user = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다");
        System.out.println("숫자를 입력해주세요 : ");

        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        String inputNum_str = Integer.toString(inputNum);

    }
}
