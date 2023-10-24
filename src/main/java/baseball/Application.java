package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int status = 1;
        while (status == 1) {

            String computer = makeRandomNums();

            String user = enterNums();
//            correct = check(computer, user);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = Integer.parseInt(Console.readLine());
        }
    }

    private static String makeRandomNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return "" + computer.get(0) + computer.get(1) + computer.get(2);
    }

    private static String enterNums() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // 숫자 자릿수가 3이 아닌 경우
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 범위 밖의 숫자나 문자를 입력한 경우
        int[] nums = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 3; i++) {
            int num = nums[i];
            if (!(num >= 1 && num <= 9)) {
                throw new IllegalArgumentException();
            }
        }

        //중복된 수를 입력한 경우
        List<Integer> dup_check = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (!dup_check.contains(nums[i])) {
                dup_check.add(nums[i]);
            } else {
                throw new IllegalArgumentException();
            }
        }

        return input;
    }
}
