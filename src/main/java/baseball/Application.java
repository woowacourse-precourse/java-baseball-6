package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = getComputerNumbers();
        List<Integer> userNumbers = getUserNumbers();

        // TODO :: computerNumbers랑 userNumbers를 비교
    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userInputNumbers = new ArrayList<>();
        try {
            String[] inputs = Console.readLine().split(""); // inputs = ["1","2","3","4"]
            for (String numberStr : inputs) {
                int numberInt = Integer.parseInt(numberStr);
                if (userInputNumbers.contains(numberInt)) {
                    throw new IllegalArgumentException("중복된 수를 넣을 수 없습니다.");
                }
                userInputNumbers.add(numberInt);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 것이 섞여 있을 때");
        }
        if (userInputNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리 수여야 합니다.");
        }
        return userInputNumbers;
    }
}