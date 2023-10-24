package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static Integer inputValue;

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public Input() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            inputValue = Integer.parseInt(bf.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> extractRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> split()  {

        if (inputValue > 999) {
            throw new IllegalArgumentException();
        }

        List<Integer> human = new ArrayList<>();

        human.add(0, inputValue/100);
        human.add(1, inputValue / 10 - human.get(0) * 10);
        human.add(2, inputValue - human.get(0)*100 - human.get(1)*10);

        if(human.contains(0)) {
            throw new IllegalArgumentException();
        }
        if(human.get(0) == human.get(1) || human.get(0) == human.get(2) || human.get(1) == human.get(2)) {
            throw new IllegalArgumentException();
        }

        return human;
    }

    public int doOrDie() throws IOException {

        inputValue = Integer.parseInt(bf.readLine());

        //inputValue가 1이나 2가 아닌 다른 숫자면 IllegalArgumentException 발생 후 종료
        if (inputValue != 1 && inputValue != 2) {
            throw new IllegalArgumentException();
        }
        return inputValue;
    }

}
