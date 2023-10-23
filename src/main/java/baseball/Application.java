package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Object;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean startFlag = true;
        ArrayList<Integer> computer = new ArrayList<>();

        while(true) {
            if(startFlag == true) {
                //랜덤 세 자리 수를 생성하는 함수
                computer = RanNumber();
                System.out.println(computer);
            }

            //player의 입력을 받는 함수
            ArrayList<Integer> player = UserInput();

            //computer와 player의 입력을 비교하여 야구 시작
            int ball = JudgeBall(computer, player);
            int strike = JudgeStrike(computer, player);

            //출력하는 함수
            PrintBaseball(ball, strike);
            String restartFlagString = "3";

            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restartFlagString = Console.readLine();
            }

            if(restartFlagString.equals("1")) {
                startFlag = true;
            }
            else if (restartFlagString.equals("2")) {
                break;
            }
            else {
                startFlag = false;
            }
        }
    }

    public static void PrintBaseball(int ball, int strike) {
        String message = "";

        if (ball != 0) {
            message += ball + "볼";
        }

        if (strike != 0) {
            if (!message.isEmpty()) {
                message += " ";
            }
            message += strike + "스트라이크";
        }

        if (message.isEmpty()) {
            System.out.print("낫싱");
        }

        System.out.println(message);
    }

    public static int JudgeStrike(ArrayList<Integer> computer, ArrayList<Integer> player) {
        int strike = 0;

        for(int i=0; i<3; i++) {
            if (computer.get(i) == player.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public static int JudgeBall(ArrayList<Integer> computer, ArrayList<Integer> player) {
        int ball = 0;

        for(int i=0; i<3; i++) {
           if (player.contains(computer.get(i)) && (computer.get(i) != player.get(i))) {
               ball++;
           }
        }
        return ball;
    }
    public static ArrayList<Integer> UserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputString = Console.readLine();
        ArrayList<Integer> playerInputArray = new ArrayList<>();

        for(int i=0; i< playerInputString.length(); i++) {
            char charDigit = playerInputString.charAt(i);
            int digit = Character.getNumericValue(charDigit);
            playerInputArray.add(digit);
        }

        return playerInputArray;
    }

    public static ArrayList<Integer> RanNumber() {
        ArrayList<Integer> randomNumArray = new ArrayList<>();

        while(randomNumArray.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);

            if(!randomNumArray.contains(randomNumber)) {
                randomNumArray.add(randomNumber);
            }
        }

        return randomNumArray;
    }
}
