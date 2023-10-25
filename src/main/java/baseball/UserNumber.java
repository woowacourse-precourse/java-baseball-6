package baseball;

public class UserNumber extends Number {
    String input;

    public UserNumber(int n){
        super(n);
    }

    public void setInput(String s) { input = s; }

    public void setUserNumberList() {
        numbers.clear();

        checkLength();
        checkIsDigit();
        checkRepeatNumber();

        for (int i = 0; i < 3; i++) {
            numbers.add((Integer) (input.charAt(i) - '0'));
        }
    }

    //=====예외 처리
    //길이 체크
    public void checkLength() {
        if(input.length() != length)
            throw new IllegalArgumentException();
    }

    //문자 유무 체크
    public void checkIsDigit() {
        //문자 유무 체크(공통)
        for(int i = 0; i < length; i++)
            if(!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException();
    }

    //세자리 수 중복 숫자 체크
    public void checkRepeatNumber() {
        for(int i = 0; i < length; i++)
            for(int j = i + 1; j < length; j++)
                if(input.charAt(i) == input.charAt(j))
                    throw new IllegalArgumentException();
    }
}
