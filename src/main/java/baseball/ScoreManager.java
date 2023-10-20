package baseball;


import java.util.List;
public class ScoreManager {
    //점수 매기기
    //점수 결과 출력하기

    static int BALL;
    static int STRIKE;
    //boolean isNothing = true;
    static boolean isAllStrike; //3스트라이크 = true

    public boolean setAndCheckScore(List<Integer> computer, List<Integer> user){ //점수를저장하고, 점수를 출력함
        BALL = 0; //실행하고 계속 반복되는 메서드이기 떄문에 초기화 해줌
        STRIKE = 0;
        isAllStrike = false;

        setScore(computer,user); //두 숫자를 비교하여 점수를 매긴다
        checkAllSolve(); //점수결과를 출력 + 3스트라이크인지 확인

        return isAllStrike;
    }

    private void setScore(List<Integer> computer, List<Integer> user){ //두 숫자를 비교하여 점수를 매긴다
        for(Integer userNum : user){
            setBallOrStrike(computer,user,userNum);
        }
    }
    private void setBallOrStrike(List<Integer> computer, List<Integer> user, Integer userNum){
        if(computer.contains(userNum)){ //만약 user의 숫자가 computer숫자에 들어있으면
            setStrike(computer,user,userNum); //ball또는 strike
        }
    }
    private void setStrike(List<Integer> computer, List<Integer> user, Integer userNum){;
        if(computer.indexOf(userNum) == user.indexOf(userNum)){ //만약 같은 숫자가 index도 같으면
            STRIKE++; //=> strike
        }else { //index번호가 다르면 (숫자만 같으면)
            BALL++;  //=>ball
        }
    }

    private void checkAllSolve(){ //3스트라이크인지 확인 + 결과 출력
        if(BALL ==0 && STRIKE == 0){
            System.out.println("낫싱");
        } else{
            checkBallOrStrike();
        }
    }
    private void checkBallOrStrike(){
        String str = ""; //최종 출력될 점수. (볼+스트라이크)로 같이 출력되는 경우를 고려하여 문자열 누적 추가

        if(BALL>0){ //출력은 볼이 먼저됨
            str += BALL+"볼"+" ";
        }
        if(STRIKE>0) {
            if(STRIKE == 3){ //만약 스트라이크면
                printFinalMsg(); //마지막 msg 출력
                isAllStrike = true; //사용자의 입력을 그만 받기위한 값을 반환한다.
            } else {
                str += STRIKE+"스트라이크"; //3이 아니라면 그냥 점수를 출력한다.
            }
        }

        System.out.println(str);
    }

    private void printFinalMsg() { //3스트라이트시 출력
        System.out.println(STRIKE+"스트라이크");
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); //print로 출력
    }

}
