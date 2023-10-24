package baseball;

public class Multi_Numeric_Comparator {
    static int count_correct_num_spot(int[] first, int[] second) {
        int count = 0;
//		if(first.length()==second.length()){
        for(int i = 0; i<second.length; i++) {
            if(first[i]==second[i]) {
                count++;
            }
        }
        return count;
//		}
    }
    static int find_wrong_spot_right_num(int index, int[] first, int[] second) {
        int count = 0;
        for(int j = 0; j<second.length; j++) {
            if(index!=j&&first[index]==second[j]) {
                count++;
            }
        }
        return count;
    }

    static int count_right_num_wrong_spot(int[] first, int[] second) {
        int count = 0;
//		if(first.length()==second.length()){
        for(int i = 0; i<second.length; i++) {
            if(first[i]!=second[i]) {
                count+=find_wrong_spot_right_num(i,first,second);
            }
        }
        return count;
//		}
    }
}
