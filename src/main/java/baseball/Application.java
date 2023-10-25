package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    // 임의의 수 3가지 부여 기능
    static List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 사용자 숫자 입력 기능
    static List<Integer> getInputNumbers() {
        List<Integer> clientNumbers = new ArrayList<>();

        String number = Console.readLine();
        for(int idx=0; idx<number.length(); idx++)
            clientNumbers.add(Character.getNumericValue(number.charAt(idx)));

        return clientNumbers;
    }

    public static void main(String[] args) {

        // 임의의 수 3가지, 사용자 입력 수
        List<Integer> randomNumbers;
        List<Integer> guessNumbers;

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 임의의 수 3가지 부여
        randomNumbers = getRandomNumbers();

        // 숫자 입력 문구 출력
        System.out.print("숫자를 입력해주세요 : ");

        // 사용자 숫자 입력
        try {
            guessNumbers = getInputNumbers();
        }
        catch (IllegalArgumentException e) {
            return;
        }
    }
}
