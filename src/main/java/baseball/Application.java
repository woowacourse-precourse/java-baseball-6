package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    private static int matchCount;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        loop:
        while(true) {
            matchCount = 0;
            int[] computer = setComputerNumbers();
            System.out.println(Arrays.toString(computer));

            while(true) {

                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if (input.length() < 3 || input.length() > 3) {
                    throw new IllegalArgumentException();
                }

                int[] inputs = new int[3];
                for (int i = 0; i < input.length(); i++) {
                    inputs[i] = input.charAt(i) - '0';
                }

                System.out.println(Arrays.toString(inputs));

                if (noNumbersMatch(computer, inputs)) {
                    System.out.println("낫싱");
                    continue;
                }

                int strike = 0;
                for (int i = 0; i < input.length(); i++) {
                    if (computer[i] == inputs[i])
                        strike++;
                }

                int ball = matchCount - strike;

                if (ball != 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike != 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.println();

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int choice = Integer.parseInt(Console.readLine());
                    if (choice == 2) {
                        break loop;
                    }
                    if(choice == 1){
                        break;
                    }
                }
            }
        }
    }

    private static int[] setComputerNumbers() {
        Set<Integer> set = new HashSet<>();
        while(set.size() < 3){
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean noNumbersMatch(int[] computer, int[] inputs) {
        boolean result = true;
        for(int input : inputs){
            for(int target : computer){
                if(input == target){
                    result = false;
                    matchCount++;
                }
            }
        }
        return result;
    }
}
