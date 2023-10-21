package baseball.utils;

public class randomComputer {
    public int[] computerRandom() {
        int[] computerNumArray = new int[3];

        for (int i = 0; i < computerNumArray.length; i++) {
            computerNumArray[i] = (int) (Math.random() * 9 + 1);
            for (int j = 0; j < computerNumArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (computerNumArray[j] == computerNumArray[i]) {
                    i--;
                    break;
                }
            }
        }
        return computerNumArray;
    }
}
