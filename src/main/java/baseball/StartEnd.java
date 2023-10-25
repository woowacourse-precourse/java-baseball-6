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
    public static StartEnd ConvertFromStr(String value){
        if(value.equals("1"))
            return StartEnd.start;
        else if(value.equals("2"))
            return StartEnd.end;
        else
            throw new IllegalArgumentException();
    }
}