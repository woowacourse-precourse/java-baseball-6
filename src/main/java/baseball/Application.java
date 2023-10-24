package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        boolean start = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(start)
        {
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println(computer);



            start = false;
        }
    }
}
