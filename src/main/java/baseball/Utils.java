package baseball;

public class Utils {
    public static boolean isDuplication(int[] numbers){
        return numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[0];
    }
}
