package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.IllegalArgumentException;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int r = 1;
        while (r == 1) {
            // 숫자야구 시작
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 숫자야구 정답 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            for (; ; ) {
                // 숫자야구 정답 입력
                List<Integer> values = null;
                try {
                    //숫자 입력 후 리스트 변환
                    System.out.print("숫자를 입력해주세요 : ");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String input = readLine();
                    // 숫자인지 확인
                    Integer.parseInt(input);
                    int[] digits = new int[input.length()];

                    for (int i = 0; i < input.length(); i++) {
                        digits[i] = input.charAt(i) - '0';
                    }

                    values = Arrays.stream(digits).boxed().collect(Collectors.toList());
                    Set<Integer> digitSet = new HashSet<>(values);

                    if ((digitSet.size() != values.size()) || (values.size() != 3) || (values.contains(0))) {
                        throw new IllegalArgumentException();
                    }

                } catch (Exception e) {
                    Exception er = new IllegalArgumentException("올바르지 않은 값입니다.");
                    er.printStackTrace();
                    System.exit(0);
                }

                //스트라이크 확인
                int strike = 0;
                int ball = 0;

                for (int i = 0; i < values.size(); i++) {
                    if (computer.get(i) == values.get(i)) {
                        strike++;
                    } else if (computer.contains(values.get(i))) {
                        ball++;
                    }
                }

                if (ball != 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike != 0) {
                    System.out.print(strike + "스트라이크 ");
                    if (strike == 3) {
                        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }

                if ((strike == 0) && (ball == 0)) {
                    System.out.println("낫싱");
                }
                System.out.println();
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String answer = readLine();
                r = Integer.parseInt(answer);

                if ((r != 1) && (r != 2)){
                    throw new IllegalArgumentException();
                }
            }
            catch (Exception e){
                Exception er = new IllegalArgumentException("올바르지 않은 값입니다.");
                er.printStackTrace();
            }
        }
    }
}
