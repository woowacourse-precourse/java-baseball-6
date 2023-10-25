package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Umpire {
    private int all;
    private int strike;
    private String judgment;
    private boolean coin;

    public Umpire(){
        newGame();
    }

    //strike + ball 개수
    public void countAll(List<Integer> computerNum, List<Integer> playerNum){
        int cnt_all = 0;
        for(int i=0;i<playerNum.size();i++){
            if(computerNum.contains(playerNum.get(i))){
                cnt_all++;
            }
        }
        setAll(cnt_all);
    }

    //strike 개수
    public void countStrike(List<Integer> computerNum,List<Integer> playerNum){
        int cnt_strike = 0;
        for(int i=0;i< playerNum.size();i++){
            if(computerNum.get(i) == playerNum.get(i)){
                cnt_strike++;
            }
        }
        setStrike(cnt_strike);
    }

    //멘트 반환
    public String Judge(){
        //하나도 못 맞힌 경우
        if(getAll() == 0){
            return "낫싱";
        }

        //하나 이상 맞힌 경우
        String cnt_judgment = "";

        if(getStrike() < getAll()){
            cnt_judgment = cnt_judgment + (getAll() - getStrike()) + "볼";
            if(getStrike()!=0){
                cnt_judgment = cnt_judgment + " " + getStrike() + "스트라이크";
            }
        } else{
            cnt_judgment = getStrike() + "스트라이크";
        }
        return cnt_judgment;
    }

    //한판 더?
    public void onceAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        char answer = input.charAt(0);

        if(answer == '1'){
            newGame();
        } else{
            setCoin(false);
        }
    }

    //게임판 초기화
    public void newGame(){
        setAll(0);
        setStrike(0);
        setJudgment("");
        setCoin(true);
    }

    public void setAll(int n){
        this.all = n;
    }

    public void setStrike(int n){
        this.strike = n;
    }

    public void setJudgment(String s){
        this.judgment = s;
    }

    public void setCoin(boolean b) {
        this.coin = b;
    }

    public int getAll(){
        return this.all;
    }

    public int getStrike(){
        return this.strike;
    }

    public String getJudgment(){
        return this.judgment;
    }

    public boolean getCoin() {
        return this.coin;
    }
}