package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 숫자 생성, 초기화
    public static List create_answer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    
    // 숫자 입력
    public static String InputNum() {
        String inputNum = Console.readLine();
        System.out.println(inputNum);
        return inputNum;
    }
    public static void main(String[] args) {
        List<Integer> computer = create_answer();
        int status = 1; // 게임 진행 상태
        while(status == 1) {
            String input = InputNum();
        }
    }
}
