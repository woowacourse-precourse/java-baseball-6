package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 숫자야구.
 */
public class Application {

    /**
     * 메인 함수.
     * @param args
     * a
     */
    public static void main(String[] args) {
        List<Integer> computer = randomNumber();
        int length = computer.size();
        boolean bool = true;

        while (bool) {
            List<Integer> user = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            int strikes = 0;
            int balls = 0;
            try {
                // 좌우의 공백문자를 제거하는 trim을 사용하고, 문자의 크기가 3이 아닐시 IllegalArgumentException
                if(input.trim().length() != 3){
                    throw new IllegalArgumentException();
                }
                // substring을 사용해 사용자에게 받은 문자열을 first second third로 나눔
                String first = input.substring(0,1);
                // parseInt를 사용해 문자를 숫자로 변환
                int firstNumber = parseInt(first);
                // 변환한 숫자를 user에 추가
                user.add(firstNumber);

                String second = input.substring(1,2);
                int secondNumber = parseInt(second);
                user.add(secondNumber);

                String third = input.substring(2,3);
                int thirdNumber = parseInt(third);
                user.add(thirdNumber);
            } catch (Exception e) {
                // user가 입력한 input이 문자열이라면 예외처리
                throw new IllegalArgumentException();
            }

            // Hashset안에 user의 input을 넣음으로써 중복되는 숫자 제거
            Set<Integer> set = new HashSet<>(user);
            List<Integer> dist = new ArrayList<>(set);

            // user의 input 데이터를 중복을 제거한 후의 크기가 3인지 체크
            if (dist.size() < 3) {
                // user의 데이터가 문자열이거나 3보다 작다면 IllegalArgumentException
                throw new IllegalArgumentException();
            }

            // computer가 만든 랜덤한 숫자와 user가 입력한 input을 비교
            for (int i = 0; i < length; i++) {
                // computer의 i번째 숫자와 user의 i번째 숫자가 같을 경우 strikes++
                if (computer.get(i).equals(user.get(i))) {
                    strikes++;
                }
                // 같은 자리의 숫자가 같은 경우가 없으니 contains를 사용해 다른 자리의 숫자가 같을 경우 balls++
                else if (computer.contains(user.get(i))) {
                    balls++;
                }
            }

            // strike와 ball이 모두 0이면 "낫싱" 출력
            if (strikes == 0 && balls == 0) {
                System.out.println("낫싱");
            }
            // 아닐 경우 strike와 ball 모두 출력
            else {
                System.out.print(balls + "볼 ");
                System.out.println(strikes + "스트라이크");
            }

            //3개의 숫자를 모두 맞췄을 경우
            if (strikes == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다 !");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String result = readLine();

                try {
                    int resultNumber = parseInt(result);
                    if (resultNumber == 1) {
                        computer = randomNumber();
                    } else if (resultNumber == 2) {
                        System.out.println("게임 종료");
                        bool = false;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    /**
     * 중복되지 않는 랜덤한 3개의 숫자를 만듦
     *
     * @return Random 3 Numbers
     */
    private static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(number)) {
                computer.add(number);
            }
        }
        return computer;
    }
}
