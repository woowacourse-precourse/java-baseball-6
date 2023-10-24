package baseball;

public enum NumberInfo {
    SIZE_OF_NUMBER(3),
    START_OF_RANGE(1),
    END_OF_RANGE(9),
    RESTART_TRUE_NUMBER(1),
    RESTART_FALSE_NUMBER(2);


    private final int numberInfo;
    NumberInfo(int numberInfo) {
        this.numberInfo = numberInfo;
    }

    public int getNumberInfo(){
        return numberInfo;
    }
}