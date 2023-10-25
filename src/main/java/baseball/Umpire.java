package baseball;

import java.util.List;

public class Umpire {
    private int all;
    private int strike;
    private String judgment;

    public Umpire(){
        setAll(0);
        setStrike(0);
        setJudgment("");
    }

    //strike + ball 개수
    void countAll(List<Integer> computerNum, List<Integer> playerNum){
        int all = 0;
        for(int i=0;i<playerNum.size();i++){
            if(computerNum.contains(playerNum.get(i))){
                all++;
            }
        }
        setAll(all);
    }

    //strike 개수
    void countStrike(List<Integer> computerNum,List<Integer> playerNum){
        int strike = 0;
        for(int i=0;i< playerNum.size();i++){
            if(computerNum.get(i) == playerNum.get(i)){
                strike++;
            }
        }
        setStrike(strike);
    }

    //멘트 반환
    String Judge(int all, int strike){
        //하나도 못 맞힌 경우
        if(all == 0){
            return "낫싱";
        }

        //하나 이상 맞힌 경우
        String judgment = "";

        if(strike < all){
            judgment = judgment + (all - strike) + "볼";

            if(strike!=0){
                judgment = judgment + " " + strike + "스트라이크";
            }
        } else{
            judgment = strike + "스트라이크";
        }
        return judgment;
    }

    void setAll(int n){
        this.all = n;
    }

    void setStrike(int n){
        this.strike = n;
    }

    void setJudgment(String s){
        this.judgment = s;
    }

    int getAll(){
        return this.all;
    }

    int getStrike(){
        return this.strike;
    }

    String getJudgment(){
        return this.judgment;
    }



}
