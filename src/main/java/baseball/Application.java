package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static List<Integer> makeRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int[] inputAndGetUserNumbers() {
        int[] arrayPlayerNumber = null;
        int userInputNumber = 0;
        String stringPlayerNumber = "";

        try {
            userInputNumber = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("정수 3자리만 입력해야 합니다.");
        }

        //입력된 수를 문자열로 변환 후 숫자 배열로 변환
        stringPlayerNumber = Integer.toString(userInputNumber);
        arrayPlayerNumber = new int[stringPlayerNumber.length()];

        //예외 처리2-2, 2-3에 대한 에러 처리
        for (int i = 0; i < stringPlayerNumber.length(); i++) {
            arrayPlayerNumber[i] = stringPlayerNumber.charAt(i) - '0';
        }
        if (arrayPlayerNumber.length != 3) {
            throw new IllegalArgumentException("3자리의 정수가 입력되지 않았습니다.");
        }
        return arrayPlayerNumber;
    }

    public static boolean checkDuplicateInput(int[] playerArray) {
        System.out.println(playerArray.length);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = null;

        for (int j : playerArray) {
            list.add(j);
        }
        set = new HashSet<Integer>(list);
        return set.size() == list.size();
    }

    public static void main(String[] args) {
        List<Integer> listAnswerNumber = makeRandomNumberList();
        int[] arrayPlayerNumber = null;

        System.out.println("숫자 야구 게임을 시작합니다. ");
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            arrayPlayerNumber = inputAndGetUserNumbers();
        }

    }
}
