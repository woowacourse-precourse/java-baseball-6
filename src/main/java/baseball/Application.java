package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //1부터 9사이의 랜덤 값 3개를 computer 리스트에 저장
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (true) {
        /*
        입력
         */
            System.out.println(computer+"(test)");
            System.out.print("숫자를 입력해주세요: ");
            String inputNumber = Console.readLine();




            /*
             * 입력 예외처리
             * 숫자인지?
             * 3자리 인지?
             * 중복되지 않는지?
             * */
            List<Integer> inputNumberList = new ArrayList<>();

            for (int i = 0; i < inputNumber.length(); i++) {
                int b = Integer.parseInt(String.valueOf(inputNumber.charAt(i)));
                inputNumberList.add(b);
            }



            /*
             * 내일 해야할것
             * 예외시 프로그램 종료하는 오류문던져야함  */


            /*
             * 비교*/
            //문자열로 입력받아서 charAt()으로 하나씩 리스트에 저장
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < computer.size(); i++) {
                for (int j = 0; j < inputNumberList.size(); j++) {
                    int randomNumber = computer.get(i);
                    int guessNumber = inputNumberList.get(j);

                    if (randomNumber == guessNumber) {
                        if (i == j)
                            strike++;
                        else
                            ball++;
                    }
                }
            }

            /*
             * 출력
             * 올라간 strike 와 ball값 출력하기
             * */
            if (strike != 0 && ball != 0) {
                System.out.println(strike + "스트라이크" + ball + "볼");

            } else if (strike != 0) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료");
                break;
            } else if (ball != 0) {
                System.out.println(ball + "볼");
            }
            else System.out.println("낫싱");
        }

    }
}
