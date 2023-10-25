package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameTool {

    /*
     * 랜덤 숫자 생성 메소드
     */
    public List<Integer> generatedRandomNumbers(int size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /*
     * 스트라이크 개수를 반환
     */
    public int countStrike(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                count++;
            }
        }
        return count;
    }

    /*
     * 볼 개수를 반환
     */
    public int countBall(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            int find = user.get(i);
            if (computer.contains(find) && computer.indexOf(find) != i) {
                count++;
            }
        }
        return count;
    }

    /*
     * 낫싱일 경우 true, 아닐 경우 false 반환
     */
    public boolean isNothing(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i))) {
                return false;
            }
        }
        return true;
    }
}
