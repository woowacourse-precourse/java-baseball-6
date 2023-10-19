package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = makeRandomNum();
        System.out.printf("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("not number");
        }
    }

    private static List<Integer> makeRandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
