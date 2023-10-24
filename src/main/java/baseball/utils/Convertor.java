package baseball.utils;

import java.util.List;

public class Convertor {
    public static String convertToString(List<Integer> list) {
        String ans = "";
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i);
        }
        return ans;
    }
}
