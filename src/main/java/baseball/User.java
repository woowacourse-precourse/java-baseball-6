package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    //입력한 값
    List<Integer> userAnswer;

    //사용자 값입력 행위
    public void InputAnswer() throws Exception {
        List<Integer> user = new ArrayList<>();

        String num = Console.readLine();
        //3개를 입력하였는지확인
        if (num.length() != 3) {
            throw new Exception();
        }

        String[] tem = num.split("");
        for (String i : tem) {
            if (Integer.parseInt(i) == 0) {
                throw new Exception("0을 입력하셨습니다.");
            }
            //숫자로 변환하여 리스트에 삽입, 문자가 있을 시 오류발생
            user.add(Integer.parseInt(i));
        }

        //중복 체크
        Set<Integer> check = new HashSet<>(user);
        if (check.size() != user.size()) {
            throw new Exception("중복되는 숫자가 있습니다.");
        }

        this.userAnswer = user;

    }
}
