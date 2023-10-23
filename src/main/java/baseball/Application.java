package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ComputerNumbers();
        PlayerNumbers();
    }

    public static void ComputerNumbers() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static ArrayList<String> PlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        ArrayList<String> playerNumbers = new ArrayList<>();
        playerNumbers.add(playerNumber);
        return playerNumbers;
    }
}
