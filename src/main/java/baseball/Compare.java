package baseball;

import java.util.List;

public class Compare {
    public int strikeCheck(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(computer.get(i) == user.get(i)) {
                count++;
            }
        }
        return count;
    }
    public int ballCheck(List<Integer> computer, List<Integer> user) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(computer.contains(user.get(i))) {
                count++;
            }
        }
        return count;
    }
}
