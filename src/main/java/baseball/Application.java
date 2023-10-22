package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomNumbers = getRandomNumbers();
        System.out.println(randomNumbers);


        System.out.print("숫자를 입력해주세요 : ");

        StringTokenizer st = new StringTokenizer(readLine(), " ");
        List<Integer> inputNumbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            inputNumbers.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(inputNumbers);
    }
    private static List<Integer> getRandomNumbers() {
        // get random numbers from 1 to 9
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int pickNumber = pickNumberInRange(1,9);
            if (!randomNumbers.contains(pickNumber)) {
                randomNumbers.add(pickNumber);
            }
        }
        return randomNumbers;
    }
}
