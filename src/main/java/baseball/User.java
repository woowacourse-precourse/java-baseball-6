package baseball;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public List<Integer> userChoice() {// 입력을 받아서 전달합니다.
        List<Integer> user_answer = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
            //입력 받아오기
        String temp_answer = readLine();
            //검사 결과 조건을 위반하면 IllegalArgumentException에러를 발생시킵니다.
        if (!userCheck(temp_answer)) throw new IllegalArgumentException();
        int temp_num_answer = Integer.parseInt(temp_answer);
        int slice = 100;
        //조건에 맞는 입력이여서 List<Integer>에 넣어줌
        for(int i=0;i<3;i++){
            user_answer.add(temp_num_answer/slice);
            temp_num_answer = temp_num_answer%slice;
            slice = slice/10;
        }
        return user_answer;
    }

    public boolean userCheck(String temp_answer){// 입력이 조건에 맞는지 검사합니다.
        boolean check_result=true;
        // 사용자 입력 길이 체크 : 3이상이면 오류
        if(temp_answer.length()!=3) check_result=false;
        else{
            // 사용자 입력에 문자열이 섞여있는지 체크
            if(!temp_answer.matches("[+-]?\\d*(\\.\\d+)?")) check_result = false;
            else{
                // 아직 좋은 방법이 떠오르지 않아서 전부 확인했습니다.
                if(temp_answer.charAt(0)==temp_answer.charAt(1)) check_result = false;
                if(temp_answer.charAt(1)==temp_answer.charAt(2)) check_result = false;
                if(temp_answer.charAt(0)==temp_answer.charAt(2)) check_result = false;
            }
        }
        return check_result;
    }
    public int regame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = readLine();
        return Integer.parseInt(answer);
    }
}
