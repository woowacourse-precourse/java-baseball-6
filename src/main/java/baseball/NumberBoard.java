package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBoard {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;
    private static final int SIZE = 3;
    private int[] answer;

    public NumberBoard(int[] answer) {
        this.answer = answer;
    }

    public static int[] makeRandomBoard() {
        int[] array = new int[SIZE];
        boolean[] used = new boolean[END_RANGE - START_RANGE + 1];
        int index = 0;
        while(index != SIZE) {
            int randomNum = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            index = pickUniqueNumber(array, used, index, randomNum);
        }
        return array;
    }

    private static int pickUniqueNumber(int[] array, boolean[] used, int index, int randomNum) {
        if (!used[randomNum]) {
            array[index] = randomNum;
            used[randomNum] = true;
            index++;
        }
        return index;
    }

    public int posNumber(int index){
        return answer[index];
    }

    public int size(){
        return SIZE;
    }
}
