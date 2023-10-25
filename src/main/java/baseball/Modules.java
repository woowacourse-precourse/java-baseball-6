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
}
