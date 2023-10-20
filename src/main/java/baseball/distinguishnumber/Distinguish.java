package baseball.distinguishnumber;

import java.util.List;

public interface Distinguish {
    String distinguish(List<Integer> answer, List<Integer> user);
    String makeString(int strike, int ball);
}
