package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import dto.Result;
import java.util.ArrayList;
import java.util.List;

public class Functions {
    public List<Integer> init() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> convert_to_list(String num) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            nums.add(num.charAt(i) - '0');
        }
        return nums;
    }

    public Result compare1(List<Integer> computer, List<Integer> person) {
        int[] res = new int[3];
        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < person.size(); j++) {
                int ball_or_strike = compare2(i, j, person.get(j), computer.get(i));
                res[ball_or_strike] += 1;
            }
        }
        return new Result(res[0], res[1]);
    }

    public Integer compare2(int i, int j, int person_num, int computer_num) {
        if (i == j && person_num == computer_num) {
            return 1;
        } else if (person_num == computer_num) {
            return 0;
        }
        return 2;
    }

    public Result inputAndCompare(List<Integer> computer) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> input_num =
                convert_to_list(input);
        if (checkException(input_num) == 1) {
            throw new IllegalArgumentException();
        }
        Result res = compare1(computer, input_num);
        return res;
    }


    private static Integer checkException(List<Integer> nums) {
        int arr[] = new int[10];
        if (nums.size() != 3) {
            return 1;
        }
        for (int i = 0; i < nums.size(); i++) {
            char n = (char) (nums.get(i) + '0');
            if (n < '1' || '9' < n) {
                return 1;
            }
            if (arr[nums.get(i)] > 0) {
                return 1;
            }
            arr[nums.get(i)] += 1;
        }
        return 0;
    }
}
