package baseball;

public class Game {
    private int strikeCnt;
    private int ballCnt;

    private void init(){
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void play(Computer computer, User user){
        init();

        for(int index=0; index<3; index++){
            if(computer.getComputerNumber(index) == user.getUserNumber(index)){
                strikeCnt++;
            } else if(computer.isComputerContains(user.getUserNumber(index))){
                ballCnt++;
            }
        }
    }

    public int getStrikeCnt(){
        return strikeCnt;
    }

    public int getBallCnt(){
        return ballCnt;
    }

    public String getGameResult(){
        // TODO: 리팩토링
        //  String값을 넘기는 것이 아닌 getStrikeCnt()와 getBallCnt()를 사용하여 다른 클래스에서 출력 할 수 있도록 바꿀 필요가 있어보임
        return ballCnt+"볼 "+strikeCnt+"스트라이크";
    }
}
