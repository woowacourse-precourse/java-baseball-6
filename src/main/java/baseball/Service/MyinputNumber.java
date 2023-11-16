package baseball.Service;

import baseball.domain.BaseballMember;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MyinputNumber {
    //내가 입력한 3개의 값을 리스트에 저장
    public void Myinputlist(){
        BaseballMember baseballMember = new BaseballMember();

        for (int i = 0; i < 3; i++) {
            System.out.println((i+1) + "번째 수 입력: ");
            baseballMember.getMyinputlist().add(i, Integer.valueOf(readLine()));  //입력받고 myinputlist에 저장
        }
    }
}
