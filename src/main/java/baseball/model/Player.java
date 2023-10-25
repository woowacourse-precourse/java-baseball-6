package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Player {
    private List<Integer> answer;

    public Player() {
        this.answer = new ArrayList<>();
        for(int i = 0; i<3; i++)
            this.answer.add(0);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer.clear();

        // 입력값 3개 이외의 값일시 예외처리
        if(answer.length() != 3)
            throw new IllegalArgumentException();

        // 숫자 이외의 값 입력 시 예외 처리
        try {
            int num = Integer.parseInt(answer);
            for(int i = 0; i<3; i++) {
                int n = num % 10;
                this.answer.add(n);
                num /= 10;
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[Input] : Only 3 digits number");
        }

        Collections.reverse(this.answer);

        // 검사 항목에 대한 예외처리
        if(!isDif(this.answer))
            throw new IllegalArgumentException("[Input] : Do not same digit");
        if(isZero(this.answer))
            throw new IllegalArgumentException("[Input] : 0 is not input");
    }

    // 동일 숫자 입력 값 검사
    public boolean isDif(List<Integer> l) {
        if(l.get(0) == l.get(1) || l.get(0) == l.get(2) || l.get(1) == l.get(2))
            return false;
        return true;
    }

    // 0 숫자 입력 값 검사
    public boolean isZero(List<Integer> l) {
        if(l.get(0) == 0 || l.get(1) == 0 || l.get(2) == 0)
            return true;
        return false;
    }

}
