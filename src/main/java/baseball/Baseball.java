package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public static void play() { // 0. 게임을 실행하는 메서드
        System.out.println("숫자 야구 게임을 시작합니다.");
        inputThreeNums();
    }

    public static void pickThreeNumbers() { // 1. 컴퓨터가 가질 3개의 값을 초기화하는 메서드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("computer = " + computer);
    }

    public void endGame() { // 2. 게임을 종료하는 메서드

    }

    public static String inputThreeNums() { // 3. 사용자로부터 숫자 3개를 입력받는 메서드
        String inputNums;
        System.out.println("숫자를 입력해주세요 : ");
        inputNums = Console.readLine();
        return inputNums;
    }

    public static String[] stringToArray(String inputString) { // 7. 사용자가 입력한 3개의 숫자를 배열로 변환하는 메서드
        String[] listedInputNums = inputString.split("");
        return listedInputNums;
    }

}
