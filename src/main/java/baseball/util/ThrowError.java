package baseball.util;

public class ThrowError {
    public static void throwError(String str) throws IllegalAccessError{
        int[] inputArr = new int[str.length()];
        for(int i = 0; i < inputArr.length; i++) {
            inputArr[i] = str.charAt(i);
        }
//        System.out.println(Arrays.toString(inputArr));
        if(checkLength(inputArr)) {
            throw new IllegalAccessError("3자리를 입력했는지 확인해주세요.");
        }
        if(checkDuplicate(inputArr)) {
            throw new IllegalAccessError("중복된 값은 입력 할 수 없습니다.");
        }
        if(checkInteger(inputArr)) {
            throw new IllegalAccessError("정수만 입력 할 수 있습니다.");
        }
    }

    public static boolean checkLength (int[] inputNumbers) {
        if(inputNumbers.length != 3) {
            return true;
        }
        return false;
    }

    public static boolean checkDuplicate (int[] inputNumbers) {
        for(int i = 0; i < inputNumbers.length; i++) {
            for(int j = i+1; j < inputNumbers.length; j++) {
                if(inputNumbers[i] == inputNumbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkInteger (int[] inputNumbers) {
        for(int i = 0; i < inputNumbers.length; i++) {
            if((65 <= inputNumbers[i] && inputNumbers[i] <= 90)||(97 <= inputNumbers[i] && 122 <= inputNumbers[i])) {
                return true;
            }
        }
        return false;
    }

}
