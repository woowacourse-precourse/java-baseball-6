package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Modules {
    public void isTypeInt(String val) {
        try{
            Integer.parseInt(val);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return;
    }

    public List<String> dropDuplicateFromArray2List(String[] val_array) {
        List<String> val_list = Arrays.asList(val_array);
        Set<String> val_set = new HashSet<>(val_list);
        return new ArrayList<>(val_set);
    }

    public List<Integer> makeRandomList(int list_len, int min_num, int max_num) {
        List<Integer> random_list = new ArrayList<>();

        while (random_list.size() < list_len) {
            int random_num = Randoms.pickNumberInRange(min_num, max_num);
            if (!random_list.contains(random_num)) {
                random_list.add(random_num);
            }
        }

        return random_list;
    }
}
