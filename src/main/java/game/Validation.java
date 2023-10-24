package game;

public class Validation {

    public static final String Three_Num = "3자리 수가 아닙니다."; // 3자리 수가 아닌 경우
    public static final String Duplicate = "중복된 숫자가 있습니다."; // 중복된 수가 있는 경우
    public static final String Invalid = "유효하지 않은 입력입니다."; // 음수, 0, 문자를 입력한 경우

    public void validation_check(String str) {
        if(invalid_check(str))
            throw new IllegalArgumentException(Invalid);
        if(str.length() != 3)
            throw new IllegalArgumentException(Three_Num);
        if(duplicate_check(str))
            throw new IllegalArgumentException(Duplicate);
    }

    // 숫자 중복 검사
    private boolean duplicate_check(String str) {
        for(int i=0; i<str.length(); i++) {
            for(int j=i+1; j<str.length(); j++) {
                if(str.charAt(i) == str.charAt(j))
                    return true;
            }
        }
        return false;
    }

    // 잘못된 입력 검사
    private boolean invalid_check(String str) {
        for(int i=0; i<str.length(); i++) {
            // 0이 포함된 경우
            if(str.charAt(i) == '0')
                return true;
            // 문자열, 음수인 경우
            else if(str.charAt(i) < '1' || str.charAt(i) > '9')
                return true;
        }
        return false;
    }

    public boolean change(String str) {
        if(invalid_check(str))
            throw new IllegalArgumentException(Invalid);
        else if(!(str.equals("1") || str.equals("2")))
            throw new IllegalArgumentException(Invalid);
        else if(str.equals("2"))
            return false;
        return true;
    }
}
