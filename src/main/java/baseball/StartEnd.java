package baseball;

public enum StartEnd{
    start(true),
    end(false);

    private boolean value;
    private StartEnd(boolean label){
        this.value = label;
    }
    public boolean getBool(){
        return this.value;
    }
}