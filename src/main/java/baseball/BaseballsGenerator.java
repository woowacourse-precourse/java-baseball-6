package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballsGenerator {

    public static Baseballs createBaseballs(String ballNumbers) {
        List<Baseball> baseballs = new ArrayList<>();
        for (int index = 0; index < ballNumbers.length(); index++) {
            try {
                baseballs.add(new Baseball(Integer.parseInt(String.valueOf(ballNumbers.charAt(index)))));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
        return new Baseballs(baseballs);
    }

}
