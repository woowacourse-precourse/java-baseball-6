package baseball;

import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static int Compare(List<Integer> computer, String user){
        List<Integer> UserInput = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            if(user.charAt(i) == '0')
                throw new IllegalArgumentException("잘못된 입력");
            int digit = Integer.parseInt(String.valueOf(user.charAt(i)));
            if (!UserInput.contains(digit))
                UserInput.add(digit);
            else
                throw new IllegalArgumentException("잘못된 입력");
        }

        int matches = 0;
        int strikes = 0;

        for (int i = 0; i < 3; i++){
            if (computer.contains(UserInput.get(i)))
                matches ++;
            //System.out.printf("%d매치", matches);
            if (computer.get(i).equals(UserInput.get(i)))
                strikes ++;

            //System.out.printf("%d스트", strikes);
        }

        if (matches == 0){
            System.out.println("낫싱");
            return 0;
        }

        int balls = matches-strikes ;

        if (balls > 0) System.out.printf("%d볼 ", balls);
        if (strikes > 0) System.out.printf("%d스트라이크", strikes);
        System.out.println("");

        if (strikes == 3)
            return 1;

        return 0;
    }
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        String user = "a";
        while(true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber))
                    computer.add(randomNumber);
            }

            System.out.println("숫자 야구 게임을 시작합니다.");

            int Flag = 0;
            while(Flag == 0) {
                System.out.print("숫자를 입력해주세요 : ");
                user = Console.readLine();

                int InputCheck = Integer.parseInt(user);
                if (!((111 <= InputCheck) && (InputCheck <= 999)))
                    throw new IllegalArgumentException("잘못된 입력");
                Flag = baseball.Application.Compare(computer, user);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            user = Console.readLine();
            if (!(user.equals("1") || user.equals("2")))
                throw new IllegalArgumentException("잘못된 입력");
            if (user.equals("2"))
                break;
        }
    }
}

