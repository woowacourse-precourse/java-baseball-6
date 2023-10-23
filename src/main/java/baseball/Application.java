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

        int cmd;
        do {
            cmd = 0;
            // 랜덤 3자리의 수 생성
            List<Integer> computerNums = new ArrayList<>();
            while (computerNums.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNums.contains(randomNumber)) {
                    computerNums.add(randomNumber);
                }
            }

            do {
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


                int ball = 0;
                int strike = 0;

                // 비교
                for (int i = 0; i < 3; i++) {
                    if (computerNums.contains(userNums.get(i))) {
                        if (computerNums.get(i).equals(userNums.get(i))) strike++;
                        else ball++;
                    }
                }

                // 힌트 제공
                if (ball == 0 && strike == 0) System.out.print("낫싱");
                if (ball!=0) System.out.print(ball + "볼" + " ");
                if (strike!=0) System.out.print(strike + "스트라이크");
                if(strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    try{
                        cmd = Integer.parseInt(Console.readLine());
                        if(cmd!=1 && cmd!=2) throw new IllegalArgumentException();
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                }

            } while(cmd != 2 && cmd != 1);
        } while(cmd != 2);
    }
}
