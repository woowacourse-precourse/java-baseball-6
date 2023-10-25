package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/** 숫자 아구를 하는 프로그램입니다.
 *
 *
 * @user UNGGU0704
 */
public class Application {
        public static void main(String[] args) {

                System.out.println("숫자 야구 게임을 시작합니다.");

                // 프로그램 시작점.
                while (true) {
                       // 컴퓨터가 무작위 수를 뽑습니다.
                       List<Integer> computer = new ArrayList<>();
                       while (computer.size() < 3) {
                               int randomNumber = Randoms.pickNumberInRange(1, 9);
                               if (!computer.contains(randomNumber)) {
                                        computer.add(randomNumber);
                               }
                       }

                        // 숫자 야구를 진행합니다.
                        while (true) {
                                int strike = 0;
                                int ball = 0;
                                System.out.print("숫자를 입력해주세요 : ");

                                String input = readLine();
                                if (!isInvariant(input))
                                        throw new IllegalArgumentException();


                                int first =  input.charAt(0) - '0';
                                int second =  input.charAt(1) - '0';
                                int third =  input.charAt(2) - '0';

                                if (first == computer.get(0)) strike++;
                                if (second == computer.get(1)) strike++;
                                if (third == computer.get(2)) strike++;

                                if (computer.contains(first)) ball++;
                                if (computer.contains(second)) ball++;
                                if (computer.contains(third)) ball++;

                                ball -= strike;

                                if (ball == 0 && strike == 0) {
                                        System.out.println("낫싱");
                                } else if (strike == 0) {
                                        System.out.println(ball + "볼");
                                } else if (ball == 0) {
                                        System.out.println(strike +"스트라이크");
                                        if (strike == 3) {
                                                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                                                break;
                                        }
                                } else {
                                        System.out.println(ball +"볼 " + strike +"스트라이크" );
                                }

                        }

                        // 사용자에게 게임을 지속할지를 물어봅니다.
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        if (Integer.parseInt(readLine()) == 2)
                                break;
                }

        }

    /** 사용자가 입력한 값이 입력조건에 맞는지 체크하는 메서드입니다.
     *
     * @param input 은 사용자가 입력한 값입니다.
     * @return input 이 모든 입력 조건을 만족하고 길이가 3인지 체크 해 true / false를 반환합니다.
     */
    private static boolean isInvariant(String input) {
                    int first =  input.charAt(0) - '0';
                    int second =  input.charAt(1) - '0';
                    int third =  input.charAt(2) - '0';
                    if (first == second || second == third || first == third) return false;
                    if ( (0 > first || first > 9) || (0 > second || second > 9) || (0 > third || third > 9) ) return false;

                    return input.length() == 3;
        }

}
