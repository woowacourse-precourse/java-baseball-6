package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> player = new ArrayList<>();
        String playerInput = Console.readLine();

        for (int i = 0; i < playerInput.length(); i++) {
            char c = playerInput.charAt(i);
            int number = Integer.parseInt(String.valueOf(c));
            player.add(number);
        }
    }
}
