package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Set_Different_Number {
    private static boolean exists(int[] n, int index) {
        for (int i = 0; i < n.length; i++) {
            if(n[i] == index)
                return true;
        }
        return false;
    }
    static int[] set_different_numbers(int num){
        int[] n= new int[num];
        int num_comparator;
        for(int i = 0; i<n.length;i++) {
            do {
                num_comparator = Randoms.pickNumberInRange(1, 9);
            }while(exists(n, num_comparator));
            n[i]= num_comparator;
        }
        return n;
    }
}
