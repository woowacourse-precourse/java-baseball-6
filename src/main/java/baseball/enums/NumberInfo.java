package baseball.enums;

public enum NumberInfo {
    COUNT(3),
    START(1),
    END(9),
    RESTART_TRUE(1),
    RESTART_FALSE(2);


    private final int numberInfo;
    NumberInfo(int numberInfo) {
        this.numberInfo = numberInfo;
    }

    public int getNumberInfo(){
        return numberInfo;
    }
}