package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application NumberBaseball = new Application();
        List<Integer> computer = NumberBaseball.generateRandomNumber();
        List<Integer> player = NumberBaseball.generateRandomNumber();
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
}
