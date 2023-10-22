package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerNumbers = new ArrayList<>();
    public static void main(String[] args) {
        Application application = new Application();

        application.printGameStartText();
        application.setComputerNumber();
    }

    public void printGameStartText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void setComputerNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

}
