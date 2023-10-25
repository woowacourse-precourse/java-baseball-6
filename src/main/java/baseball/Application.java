package baseball;
import inputnumber.InputNumber;
import makenumber.MakeNumber;
import printcount.PrintCount;
import camp.nextstep.edu.missionutils.*;
import numbercompare.Compare;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //System.out.println(computer + "컴퓨터 리스트");
        boolean check = true;
        while (check) {

            System.out.print("숫자를 입력해주세요 : ");

            // 이용자의 입력값
            InputNumber inputnumber = new InputNumber();
            String input = Console.readLine();
            // 입력값 확인
            inputnumber.NumberCheck(input);

            // 볼, 스트라이크 판정
            int [] k = Validation(input, computer);

            int ball = k[0];
            int strike = k[1];

            PrintCount count = new PrintCount();
            count.CountResult(ball,strike);

            // 모두 맞춘 경우
            if (k[1] == 3) {

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int last = Integer.parseInt(Console.readLine());

                if (last == 2) {
                    check = false;
                } else {
                    MakeNumber number = new MakeNumber();
                    number.numberList();
                }
            }
        }
    }

    // 볼, 스트라이크 판정
    public static int[] Validation(String input, List<Integer> computer) {
        int[] result;

        List<Integer> li = new ArrayList<Integer>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                li.add(digit);
            }
        }

        Compare compare = new Compare();
        result = compare.CompareResult(li, computer);

        return result;
    }
}