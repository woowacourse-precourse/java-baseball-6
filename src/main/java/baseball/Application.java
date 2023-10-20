package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNums;
        List<Integer> userNums;

        computerNums = choiceComputerNums();
        printComputerNums(computerNums);

        userNums = inputUserNums();

    }

    private static List<Integer> choiceComputerNums() {
        List<Integer> computerNums;
        computerNums = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computerNums;
    }


    public static void printComputerNums(List<Integer> computerNums) {
        System.out.print("컴퓨터 수 = ");
        for (int computerNumber : computerNums) {
            System.out.print(computerNumber);
        }
        System.out.println();
    }

    public static List<Integer> inputUserNums() {
        List<Integer> userNums;
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        userNums = splitNum(Integer.parseInt(input));
        // 서로 다른 3개의 숫자가 아닌 예외 상황 구현

        return userNums;
    }

    private static List<Integer> splitNum(int number) {
        List<Integer> Nums = new ArrayList<>();
        Nums.add(number / 100);
        Nums.add((number / 10) % 10);
        Nums.add(number % 10);
        return Nums;
    }

}

