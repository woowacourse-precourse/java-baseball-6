package baseball.function;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    public static int[] getRandomNum() {
        int[] computerNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            computerNumber[i] = getUniqueRandomNum(computerNumber, i);
        }
        return computerNumber;
    }


    private static int getUniqueRandomNum(int[] Number, int i) {

        ChkDigit ChkDigit = new ChkDigit();

        int Num = Randoms.pickNumberInRange(1, 9);

        while (!ChkDigit.chkUnique(Number,i,Num)) {
            Num = Randoms.pickNumberInRange(1,9);
        }
        return Num;
    }
}