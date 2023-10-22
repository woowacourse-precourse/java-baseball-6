package baseball;

public class Util {
    public static int[] parsingNumberToNumberList(int parsingNumber,int digitCount) {
        int sliceUnit = (int) Math.pow(10, digitCount - 1);
        var numberList = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            int number = parsingNumber / sliceUnit;
            numberList[i]=number;
            parsingNumber %= sliceUnit;
            sliceUnit /= 10;
        }
        return numberList;
    }
}
