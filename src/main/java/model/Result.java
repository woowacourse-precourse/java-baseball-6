package model;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<String, Integer> playResult = new HashMap<String, Integer>();

    public void setterResult(String name, Integer count) {
        this.playResult.put(name, count);
    }

    public Map<String, Integer> getterResult() {
        return new HashMap<String, Integer>(playResult);
    }

}
