package baseball;

import java.util.ArrayList;

public class ContinueNumber {
    String input;
    int length;

    public ContinueNumber(int n) {
        length = n;
    }

    public void setInput(String s) { input = s; }

    public boolean returnFlag() {
        if(input.equals("1"))
            return true;
        else
            return false;
    }
    public void checkInput() {
        checkLength();
        checkIsDigit();
        checkBoundary();
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

    //1,2 이외의 수 체크
    public void checkBoundary() {
        if(!(input.equals("1") || input.equals("2")))
            throw new IllegalArgumentException();
    }
}
