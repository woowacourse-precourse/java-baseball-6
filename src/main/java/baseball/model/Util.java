package baseball.model;

import java.util.Arrays;

public class Util {

    public static boolean isDuplicateNumber(int[] nums) {
        return Arrays.stream(nums).distinct().count() < 3;
    }
    
    public static boolean isDuplicateNumber(String nums) {
        return Arrays.stream(nums.split("")).distinct().count() < 3;
    }

    public static boolean isInArray(int num, int[] nums) {
        return Arrays.stream(nums).anyMatch(n -> num == n);
    }

    public static int[] stringToIntArray(String nums) {
        return Arrays.stream(nums.split("")).mapToInt(Integer::parseInt).toArray();
    }

}
