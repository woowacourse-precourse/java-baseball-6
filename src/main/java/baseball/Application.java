package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class Application {
    public static int baseballGame(List<Integer> computerNum) {

        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();

        if (userNum.length() != 3 || userNum.chars().distinct().count() != 3) {
            throw new IllegalArgumentException();
        }


        int strike = 0;
        int ball = 0;


        for (int i=0; i<3; i++) {
            int userDigit = Character.getNumericValue(userNum.charAt(i));
            int computerDigit = computerNum.get(i);

            if (userDigit == computerDigit) {
                strike++;
            } else if (computerNum.contains(userDigit)) {
                ball++;
            }
        }


        String answer = "";
        if (strike == 0 && ball == 0) {
            answer = "낫싱";
        }
        else {
            if (ball > 0) answer += String.format("%d볼", ball);
            if (strike > 0) answer += String.format(" %d스트라이크", strike);
        }

        System.out.println(answer);
        if (strike != 3) return baseballGame(computerNum);
        else return strike;
    }
    
    public static void main(String[] args) {
        int regame = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();

        while (regame == 1) {
            computer.clear();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            int strike = baseballGame(computer);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                regame = Integer.parseInt(Console.readLine());
            }
        }
            
    }
}

