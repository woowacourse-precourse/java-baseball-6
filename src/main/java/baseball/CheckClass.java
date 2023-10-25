package baseball;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CheckClass {
    public static List<Integer> checkDup(List<Integer> cv){
        if(cv.size() > 10)
            throw new IllegalArgumentException();
        Set<Integer> set = new TreeSet<>();

        for(int i=1;i<=9;i++)
            set.add(i);

        for (Integer value : cv) {
            if (!set.contains(value))
                throw new IllegalArgumentException();
            set.remove(value);
        }
        return cv;
    }

    public static String checkLength(String str, int length){
        if(str.length() != length)
            throw new IllegalArgumentException();
        return str;
    }
}
