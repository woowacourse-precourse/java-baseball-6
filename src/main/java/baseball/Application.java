package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String computerNumber = shuffleNumber();

        System.out.print("숫자를 입력해 주세요 : ");
        String user = Console.readLine();

        if (user.length() != 3) {
            throw new IllegalArgumentException("3개의 값을 입력해주세요");
        }
        if (!user.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
        String tmp = "";
        for (char c : user.toCharArray()) {
            if (tmp.equals(String.valueOf(c))) {
                throw new IllegalArgumentException("중복되지 않는 숫자로 입력해주세요");
            }
            tmp += String.valueOf(c);
        }

        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            int computerDigit = computerNumber.charAt(i);
            int userDigit = user.charAt(i);

            if (computerDigit - 1 == userDigit || computerDigit + 1 == userDigit) {
                ball += 1;
            }

            if (computerDigit == user.charAt(i)) {
                strike += 1;
            }
        }

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }


    }

    public static String shuffleNumber() {
        // 랜덤값 생성
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return String.join("", computer);
    }
}
