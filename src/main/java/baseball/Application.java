package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // TODO: 1. 랜덤으로 서로 다른 3자리 수 조합 만들기


        // TODO: 2. 사용자가 입력한 3자리 수 비교하기

        try {
            List<Integer> computerNumbers;

            computerNumbers = createRandomNumbers();
            List<Integer> numbers = new ArrayList<>();

            int end = 1;

            while (end != 2) {
                numbers.clear();
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
//                System.out.println(input);
                if (!correctNumbers(input)) {
                    throw new IllegalArgumentException();
                }

                for (String num : input.split("")) {
                    numbers.add(Integer.parseInt(num));
                }
//                System.out.println(Arrays.toString(numbers.toArray()));

                // TODO: 3. 입력에 대한 결과 출력하기

                int ball = 0;
                int strike = 0;
                for (int i = 0; i < computerNumbers.size(); i++) {
                    if (computerNumbers.get(i) == numbers.get(i)) strike++;
                    else if (computerNumbers.contains(numbers.get(i))) ball++;
                }

                ball = ball - strike;
                String answer = "";
                if (ball == 0 && strike == 0) {
                    answer = "낫싱";
                } else {
                    if (ball > 0) {
                        answer = ball + "볼";
                    }
                    if (strike > 0) {
                        answer = answer + " " + strike + "스트라이크";
                    }
                }

                System.out.println(answer);

                if(strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    end = Integer.parseInt(Console.readLine());
                }

            }

        } catch(IllegalArgumentException iae) {
            return;
        }

        // TODO: 4. 숫자를 전부 맞추면 다시 시작하거나 종료하기

    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

//    private static boolean checkInputLength()

    private static boolean correctNumbers(String input) {
        if (input.length() != 3)
            return false;

        if(!input.matches("[1-9]+"))
            return false;

        List<String> numbers = new ArrayList<>();
        for(String num : input.split("")){
            if(!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        return numbers.size() == 3;
    }
}
