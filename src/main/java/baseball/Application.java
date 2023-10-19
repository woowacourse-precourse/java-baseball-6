package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 시작 문구

            List<Integer> computer = new ArrayList<>(); // 랜덤 숫자 생성
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }




                System.out.print("숫자를 입력해주세요 : ");
                String myInput = Console.readLine(); // 입력 숫자 생성

                List<Integer> myNum = new ArrayList<>(); // 입력 숫자를 리스트로 변경
                for (int i = 0; i < myInput.length(); i++) {
                    char digitChar = myInput.charAt(i);
                    int digit = Character.getNumericValue(digitChar);
                    myNum.add(digit);
                }




    }
}