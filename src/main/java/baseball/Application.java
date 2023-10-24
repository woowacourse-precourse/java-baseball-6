package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
//
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean gameSet = true;
        while (gameSet) {
            int strike = 0;
            int ball = 0;
            System.out.println("숫자 야구 게임을 시작합니다.");

            //컴퓨터 함수 부분
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println(computer);

            //입력 부문
            userNumber();
//            List<Integer> user = new ArrayList<>();
//            String input = Console.readLine();
//            System.out.println(input);
//
//            for (String number : input.split("")) {
//                user.add(Integer.parseInt(number));
//            }
//            check(input); // 예외처리

            //strike
            for (int i = 0; i < user.size(); i++) {
                if (computer.get(i) == user.get(i)) {
                    strike++;
                }

            }
            System.out.println(strike);
            //ball
            for (int i = 0; i < user.size(); i++) {
                if (computer.contains(user.get(i)) && computer.get(i) != user.get(i)) {
                    ball++;
                }
            }
            System.out.println(ball);
            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                char answer = Console.readLine().charAt(0);
                if (answer == '2') {
                    gameSet = false;
                }
            }
        }
    }


    //예외 처리
    public static void check(String user) throws IllegalArgumentException{
        boolean isNumeric = true;
        for(int i = 0; i < user.length(); i++) {
            if (!Character.isDigit(user.charAt(i))) {
                isNumeric = false;
            }
        }
        if(user.length() != 3 || !isNumeric){
            throw new IllegalArgumentException("3자리 정수를 입력해주세요");
        }
    }

    //입력 부분
    public static List<Integer> userNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> user = new ArrayList<>();
        String input = Console.readLine();
        System.out.println(input);

        for (String number : input.split("")) {
            user.add(Integer.parseInt(number));
        }
        check(input);
        return user;
    }

}

