package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Boolean isPlaying = Boolean.TRUE;

        while (isPlaying) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            Boolean isCorrect = Boolean.FALSE;
            while (!isCorrect){
                int ball = 0;
                int strike = 0;

                System.out.print("숫자를 입력해주세요 : ");
                int inputNum;
                try {
                    inputNum = Integer.parseInt(Console.readLine());
                } catch (InputMismatchException e) {
                    //6-3. 숫자가 아닌 문자가 입력되는 경우
                    throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
                }

                //6-1. 3자리 숫자가 아닌경우, 6-5. 음수인 경우
                if (inputNum<100 || inputNum > 999) throw new IllegalArgumentException("[ERROR] 3자리 숫자를 입력해주세요.");

                int isoverlap = inputNum;
                int a = isoverlap % 10;
                isoverlap /= 10;
                int b = isoverlap % 10;
                isoverlap /= 10;
                int c = isoverlap;

                //6-2. 숫자에 중복이 들어가는 경우
                if ( a == b || b == c || c == a) throw new IllegalArgumentException("[ERROR] 숫자는 중복되면 안됩니다.");

                //6-4. 0이 포함되는 경우
                if (a == 0 || b == 0 || c == 0) throw new IllegalArgumentException("[ERROR] 숫자에 0이 포함되면 안됩니다.");


                int[] intArray = new int[3];
                for (int i = 2; i >= 0; i--) {
                    intArray[i] = inputNum % 10;
                    inputNum = inputNum / 10;
                }
                for (int i = 0; i < 3; i++) {

                    if (computer.contains(intArray[i])) {
                        if (computer.get(i) == intArray[i]) {
                            //위치가 같으면
                            strike++;
                        }
                        //위치가 다르면
                        else ball++;
                    }
                }
                if (strike == 3) {
                    isCorrect = Boolean.TRUE;
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int isReplaying = Integer.parseInt(Console.readLine());
                    if (isReplaying == 2) isPlaying = Boolean.FALSE;
                }
                else if (ball > 0 && strike > 0) System.out.println(ball + "볼 " + strike +"스트라이크");
                else if (ball > 0) System.out.println(ball + "볼");
                else if (strike > 0) System.out.println(strike + "스트라이크");
                else System.out.println("낫싱");
            }
        }
    }
}
