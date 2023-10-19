package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static void displayGameStartMessage()  {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateComputerRandomThreeDigitNumber(){

        List<Integer> computer = new ArrayList<>();
        while(computer.size() <3 ){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getUserGuessThreeDigitNumber(){

        List<Integer> user = new ArrayList<>();
        String userThreeNumbers = Console.readLine();
        for(int i=0;i<userThreeNumbers.length();i++){
            user.add(userThreeNumbers.charAt(i)-'0');
        }
        return user;
    }
}
