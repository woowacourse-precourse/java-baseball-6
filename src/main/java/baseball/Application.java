package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static List<Integer> answer = new ArrayList<>();

    public static void initRandom() {
        answer.clear();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public static String validate(int input) throws IllegalArgumentException {
        int strike = 0;
        int ball = 0;

        String str = Integer.toString(input);

        //잘못된 입력 예외처리
        try {
            if (!(input >= 123 && input <= 987
                    && str.charAt(0) != str.charAt(1)
                    && str.charAt(0) != str.charAt(2)
                    && str.charAt(1) != str.charAt(2))) {

                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

        //strike와 ball 숫자 카운트
        for (int i = 2; i >= 0; i--) {
            if (answer.contains(input % 10)) {
                if (answer.indexOf(input % 10) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
            input /= 10;
        }

        //결과에 따라 알맞은 출력값을 return
        if (strike != 0 && ball != 0) {
            return Integer.toString(ball) + "볼 " + Integer.toString(strike) + "스트라이크";
        } else if (ball != 0) {
            return Integer.toString(ball) + "볼";
        } else if (strike != 0) {
            return Integer.toString(strike) + "스트라이크";
        } else {
            return "낫싱";
        }
    }

    public static void run() throws IllegalArgumentException{

        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);

        while (true) {
            initRandom();
            while (true) {
                int input;
                String result;
                try {
                    System.out.print("숫자를 입력해주세요 : ");
                    input = sc.nextInt();
                } catch (RuntimeException e) {
                    throw new IllegalArgumentException();
                }

                try {
                    result = validate(input);
                } catch (IllegalArgumentException e) {
                    throw e;
                }

                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            int input;
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = sc.nextInt();
            }catch (RuntimeException e){
                throw new IllegalArgumentException();
            }

            if (input == 2)
                break;
            else if (input != 1)
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args){
        try{
            run();
        } catch (IllegalArgumentException e){
            throw e;
        }
    }
}
