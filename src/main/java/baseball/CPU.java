package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CPU {
    public List<Integer> CPUNum(){

        List<Integer> cpu_num = new ArrayList<>();
        while (cpu_num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!cpu_num.contains(randomNumber)) {
                cpu_num.add(randomNumber);
            }
        }
        return cpu_num;
    }
}
