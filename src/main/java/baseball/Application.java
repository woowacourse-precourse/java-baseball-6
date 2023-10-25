package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> computer = new ArrayList<>();
        ArrayList<Integer> userNumber = new ArrayList<>();
        int randomNumber = 0;
        int number = 0;
        boolean regame = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {

            if(regame) {
                computer.clear();

                //컴퓨터 랜덤 수 구하기
                while (computer.size() < 3) {
                    randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
            }

            System.out.print("숫자를 입력해주세요 : ");
            String input = sc.next();


            number = Integer.parseInt(input);
            validateNumber(number);

            //사용자가 입력한 후 userNumber에 넣기
            userNumber.clear();
            userNumber.add(number / 100);
            int temp = number % 100;
            userNumber.add(temp / 10);
            userNumber.add(temp % 10);

            int[] result = checkNumber(computer, userNumber);
            regame = printResult(result);

            if(regame){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                input = sc.next();
                number = Integer.parseInt(input);

                // 1 또는 2가 아닌 경우
                if (!(number == 1 || number == 2)) {
                    throw new IllegalArgumentException("Invalid argument" + number);
                }

                if(number == 2) break;
            }
        }
    }

    public static void validateNumber(int number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("세자리 수가 아닙니다: " + number);
        }

        int digit1 = number / 100;
        int digit2 = (number % 100) / 10;
        int digit3 = number % 10;

        if (digit1 == digit2 || digit2 == digit3 || digit1 == digit3) {
            throw new IllegalArgumentException("각 자리의 숫자가 다르지 않습니다: " + number);
        }
    }


    public static int[] checkNumber(ArrayList<Integer> computer, ArrayList<Integer> userNumber){
        //result[0] = strike, result[1] = ball
        int[] result = new int[2];

        for(int i=0; i<3; i++){
            if(Objects.equals(computer.get(i), userNumber.get(i))) result[0]++;
            else if(computer.contains(userNumber.get(i))) result[1]++;
        }

        return result;
    }

    public static boolean printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return false;
    }
}
