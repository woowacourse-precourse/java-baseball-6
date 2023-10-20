package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static void createComputerNum(List<Integer> computerNum) {
        while(computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }
    static String receiveUserNum() {
        String userNum;

        System.out.print("숫자를 입력해주세요 : ");
        userNum = Console.readLine();
        return userNum;
    }
    static int[] referee(List<Integer> computerNum, String userNum) {
        int[] cntResult = new int[2];
        for(int i = 0; i < 3; i++) {
            if(computerNum.get(i) == userNum.charAt(i)-'0') {
                cntResult[0]++;
            } else {
                cntResult[1]++;
            }
        }
        return cntResult;
    }
    public static void main(String[] args) {
        String startFlag = "1";

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(startFlag.equals("1")) {
            List<Integer> computerNum = new ArrayList<>();
            boolean correctFlag = false;

            createComputerNum(computerNum);
            System.out.println(computerNum.get(0));
            System.out.println(computerNum.get(1));
            System.out.println(computerNum.get(2));
            while(!correctFlag) {
                String userNum;
                int[] cntResult;
                int ball;
                int strike;
                userNum = receiveUserNum();
                cntResult = referee(computerNum, userNum);
                strike = cntResult[0];
                ball = cntResult[1];

                switch (strike) {
                    case 0:
                        System.out.println(String.format("%d볼", ball));
                        break;
                    case 3:
                        System.out.println(String.format("%d스트라이크", strike));
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                        correctFlag = true;
                        break;
                    default:
                        System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
                        break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            startFlag = Console.readLine();
        }
    }
}