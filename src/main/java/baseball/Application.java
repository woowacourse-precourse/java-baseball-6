package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        System.out.println(computer);



        List<Integer> my = new ArrayList<>();
        String inputNumbers = readLine();

        if (inputNumbers.length() != 3){
            throw new IllegalArgumentException("입력한 숫자 길이가 맞지 않습니다.");
        }

        for (int i = 0; i < inputNumbers.length(); i++){
            try {
                int number = Character.getNumericValue(inputNumbers.charAt(i));
                my.add(number);
            } catch (Exception e) {
                throw new IllegalArgumentException("입력한 문자가 숫자가 아닙니다.");
            }

        }

        System.out.println(my);

    }
}
