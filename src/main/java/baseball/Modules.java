package baseball;

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
}
