package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static int strike;
    static int ball;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            strike = 0;
            ball = 0;
            List<Integer> computerNum = new ArrayList<>();
            while (computerNum.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNum.contains(randomNumber)) {
                    computerNum.add(randomNumber);
                }
            }
            while (strike !=3) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> userNum = checkInputData(Console.readLine());
                checkComNum(computerNum, userNum);

                if (ball > 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
                if (ball + strike == 0) {
                    System.out.println("낫싱");
                }else {
                    System.out.println("");
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String order = Console.readLine();
            if (checkNumber(order) && Integer.parseInt(order) == 2) {
                break;
            }
            if (!checkNumber(order) || order.length() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> checkInputData(String inputData) {
        List<Integer> userNum = new ArrayList<>();
        if (inputData.length() != 3 || !checkNumber(inputData)) {
            throw new IllegalArgumentException();
        }
        String[] userNum2 = inputData.split("");
        for(int i=0; i<userNum2.length; i++) {
            int userNum3 = Integer.parseInt(userNum2[i]);
            if (!userNum.contains(userNum3)) {
                userNum.add(userNum3);
            }
        }
        if (userNum.size() < 3) {
            throw new IllegalArgumentException();
        }

        return userNum;
    }
    public static boolean checkNumber(String str){
        char check;
        if(str.equals("")) {
            return false;
        }
        for(int i = 0; i<str.length(); i++){
            check = str.charAt(i);
            if( check < 48 || check > 58) {
                return false;
            }
        }
        return true;
    }
    public static void checkComNum(List<Integer> computerNum, List<Integer> userNum) {
        strike = 0;
        ball = 0;
        for(int i=0; i<computerNum.size(); i++) {
            for(int j=0; j<userNum.size(); j++) {
                if(i == j && computerNum.get(i) == userNum.get(j)) {
                    strike++;
                }
                if(i != j && computerNum.get(i) == userNum.get(j)) {
                    ball++;
                }
            }
        }
    }
}
