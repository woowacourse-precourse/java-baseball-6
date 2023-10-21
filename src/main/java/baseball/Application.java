package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 게임 시작을 사용자에게 알린다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            // 컴퓨터 숫자 랜덤 생성
            List<Integer> computer = new ArrayList<>();
            makeRandomNumber(computer);

            while (true) {
                // 사용자 숫자 입력
                List<Integer> user = new ArrayList<>();
                int [] result = new int[2];

                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                inputValidation(input, user);

                // 컴퓨터의 수와 사용자의 수 비교
                compare(computer, user, result);

                if(viewResult(result)) break;

            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            if(choice == 2) break;
            else if(choice == 1) continue;
            else throw new IllegalArgumentException("1 또는 2만 입력하세요");
        }


    }

    public static boolean viewResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) System.out.println("낫싱");
        else if (result[0] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if (result[1] == 0) System.out.println(result[0] + "스트라이크");
        else if (result[0] == 0) System.out.println(result[1] + "볼");
        else System.out.println(result[1] + "볼 " + result[0] + "스트라이크");

        return false;
    }

    public static void compare(List<Integer> computer, List<Integer> user, int[] result) {
        for (int i = 0; i < 3; i++) {
            int num = user.get(i);
            if (computer.contains(num)) {
                if (computer.get(i) == num) result[0]++;
                else result[1]++;
            }
        }
    }

    public static void inputValidation(String input, List<Integer> user) {
        if (input.length() != 3) throw new IllegalArgumentException("세 자리 숫자가 아니다.");

        for (int i = 0; i < 3; i++) {
            char splitInput = input.charAt(i);
            if (!Character.isDigit(splitInput) || splitInput == '0')
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력하세요");

            int inputInt = Character.getNumericValue(splitInput);
            if (user.contains(inputInt)) throw new IllegalArgumentException("같은 숫자가 존재한다");
            user.add(inputInt);
        }
    }

    public static void makeRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                //System.out.println(randomNumber);
            }
        }
    }

}
