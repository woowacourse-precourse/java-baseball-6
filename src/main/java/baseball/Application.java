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

        List<Integer> inputNumbers = getInputNumbers();
        System.out.println(inputNumbers);


        System.out.println(getAnswer(randomNumbers, inputNumbers));




    }

    private static boolean getAnswer(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        boolean isAnswer = true;
        for (int index=0; index<3; index++){
            if (!randomNumbers.get(index).equals(inputNumbers.get(index))) {
                isAnswer = false;
                break;
            }
        }
        return isAnswer;
    }

    private static List<Integer> getInputNumbers() {
        // get numbers from user input
        System.out.print("숫자를 입력해주세요 : ");

        String input = readLine();
        List<Integer> inputNumbers = new ArrayList<>();
        for (int index=0; index<3; index++){
             inputNumbers.add(Integer.parseInt(input.substring(index, index+1)));
        }
        return inputNumbers;
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
