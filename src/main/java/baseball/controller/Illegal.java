package baseball.controller;

public class Illegal {

    public void checkIllegal(String num) {
        int integerNumber = parseIntNumber(num);
        illegalNotThree(integerNumber);
    }

    public int parseIntNumber(String num) throws IllegalArgumentException {
        int intNum;
        try {
            intNum = Integer.parseInt(num);
        } catch (Exception e) {
            // TODO: handle exception
            throw new IllegalArgumentException();
        }
        return intNum;
    }

    public void illegalNotThree(int num) throws IllegalArgumentException {
        if (num < 100 || num >= 1000) {
            throw new IllegalArgumentException();
        }
    }

    public int[] illegalIncludeZeroOrDuplicate(int num) throws IllegalArgumentException {
        int sepNum[] = new int[3];
        for (int i = 0; i < sepNum.length; i++) {
            int div = 10;
            sepNum[i] = num % div;
            if (sepNum[i] == 0) {
                throw new IllegalArgumentException();
            }
            num /= 10;
        }
        for (int i = 0; i < sepNum.length - 1; i++) {
            for (int j = i + 1; j < sepNum.length; j++) {
                if (sepNum[i] == sepNum[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
        int tmp = sepNum[0];
        sepNum[0] = sepNum[2];
        sepNum[2] = tmp;

        return sepNum;
    }
}
