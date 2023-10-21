package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> computer;

    public static void main(String[] args) throws Exception {

        System.out.println("숫자 야구 게임을 시작합니다.");
        genNumbers();

        while(true) {

            System.out.print("숫자를 입력해주세요 : ");
            String iNumbers = Console.readLine();

            /*
            입력된 내용에 대해 검사해 봐야 하는 것
            1. 숫자는 맞는가?
            2. 3자리의 숫자인가?
             */

            if(iNumbers.length() != 3) {
                throw new IllegalArgumentException("3자리의 숫자가 입력되어야 합니다.");
            }

            try {
                Integer.parseInt(iNumbers);
            } catch(NumberFormatException e) {
                //NumberFormatException은 IllegalArgumentException의 하위 예외이다.
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }

        }

    }

    static void genNumbers() {

        computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            //1부터 9까지의 난수 중 중복되지 않게 3개의 난수를 computer라는 리스트에 집어넣음.
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

    }
}
