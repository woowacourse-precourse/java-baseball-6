package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application NumberBaseball = new Application();
        List<Integer> computer = NumberBaseball.generateRandomNumber();
        List<Integer> player = NumberBaseball.getPlayerNumber();
        System.out.println(computer);
        System.out.println(player);
        System.out.println(Arrays.toString(NumberBaseball.calculateResult(computer, player)));
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int[] calculateResult(List<Integer> computer, List<Integer> player) {
        int[] result = new int[2]; //[strike, ball]
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).equals(computer.get(i))) {
                result[0]++;
            } else if (computer.contains(player.get(i))) {
                result[1]++;
            }
        }
        return result;
    }

    public List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return validatePlayerNumber(input);
    }

    public List<Integer> validatePlayerNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("수가 아닙니다.");
            }
            int playerNumber = Character.getNumericValue(c);
            if (player.contains(playerNumber)) {
                throw new IllegalArgumentException("서로 다르지 않습니다.");
            }
            player.add(playerNumber);
        }
        return player;
    }
}
