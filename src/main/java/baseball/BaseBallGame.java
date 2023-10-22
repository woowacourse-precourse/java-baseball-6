package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    static String answer="";
    static String checkAnswer="";
    static List<String> computer = new ArrayList<>();
    public void start() throws IllegalArgumentException{
        System.out.println("숫자 야구게임을 시작합니다.");

        while(true){
            System.out.print("숫자를 입력 해주세요: ");
            computerInput();
        }
    }

    private void computerInput() {
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

}


}
