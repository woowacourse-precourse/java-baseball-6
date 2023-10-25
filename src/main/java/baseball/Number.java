package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Number {
    public Number() { }

    private List<Integer> user = new ArrayList<>();
    private List<Integer> computerList = new ArrayList<>();

    public void setRandomNumber() {
        computerList.clear();
        while (computerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }
        System.out.println(computerList);
    }

    public void inputUser() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        String[] numberStrings = input.split(""); // 공백을 기준으로 분할
        // 입력값 check
        if (numberStrings.length != 3) {
            throw new IllegalArgumentException();
        } else {
            user.clear(); // 사용자가 맞추지 못한 경우, user list 초기화
            for (String str : numberStrings) {
                try {
                    Integer newStr = Integer.parseInt(str);
                    user.add(newStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }
        }
    }
    public List<Integer> getComputerList() {
        return computerList;
    }
    public List<Integer> getUserList() {
        return user;
    }
}
