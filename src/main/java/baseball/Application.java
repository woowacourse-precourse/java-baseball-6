package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Object;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restartFlag = true;

        while(restartFlag == true) {
            //랜덤 세 자리 수를 생성하는 함수
            ArrayList<Integer> computer = RanNumber();

            //player의 입력을 받는 함수
            ArrayList<Integer> player = UserInput();


        }




    }

    public static ArrayList<Integer> UserInput() {
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
