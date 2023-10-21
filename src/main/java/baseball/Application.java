package baseball;

import baseball.utils.RandomUtils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int[] answer = RandomUtils.getRandomNumbers();
        int [] inputNum = new int[3];

        String input = Console.readLine();
        for(int i=0; i<answer.length; i++) {
            inputNum[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
    }
}
