package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Application {
    public static void main(String[] args) {

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 랜덤 3자리의 수 생성
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }

        // 3자리의 수 입력 받기
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> userNums = new ArrayList<>();
        Arrays.stream(input.split("")).forEach(str -> {
            try {
                Integer num = Integer.parseInt(str);
                // 각 자릿수끼리 중복된 수를 입력한 경우 || 각 자릿수가 1 ~ 9까지의 수가 아닌 경우
                if (userNums.contains(num) || num == 0) throw new IllegalArgumentException();
                userNums.add(num);
            }
            // 숫자 외의 문자를 입력한 경우
            catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        });

        // 입력 받은 수가 3자리가 아닌 경우
        if (userNums.size() != 3) throw new IllegalArgumentException();

    }
}
