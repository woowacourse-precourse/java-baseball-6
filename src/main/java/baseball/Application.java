package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static List<Integer> randomNumMaker() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean isValidNumber(String input) {
        if (input.length() != 3) {
            return false;
        }
        if (!input.matches("^[0-9]+$")) {
            return false;
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(
                2)) {
            return false;
        }
        return true;
    }

    public static List<Integer> stringToList(String input) {
        char [] strChar = input.toCharArray();
        List<Integer> userNum = new ArrayList<Integer>();
        for (int i=0; i < input.length(); i++){
            int n = Character.getNumericValue(strChar[i]);
            userNum.add(n);
        }
        return userNum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNum = randomNumMaker();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (!isValidNumber(input)) {
                throw new IllegalArgumentException();
            } else {
                List<Integer> userNum = stringToList(input);
                System.out.println(userNum+""+computerNum);
            }
        }

    }
}