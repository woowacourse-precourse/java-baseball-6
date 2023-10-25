package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Game {
    private int ball=0;
    private int strike=0;
    private boolean flag = true;
    private boolean chk;
    public Game(boolean chk){
        this.chk = chk;
    }
    public boolean getChk(){
        return chk;
    }

    public boolean startGame(List<Integer> li){
        while (flag){
            System.out.printf("숫자를 입력해주세요 : ");
            String rl = readLine(); //서로 다른 3자리의 수
            validationReadLine(rl);
            inputCount(rl,li);
            printScore();
        }
        return chk;
    }
    private void validationReadLine(String rl) {
        List<Character> numList = new ArrayList<>();

        for(int i = 0;i<rl.length();i++){
            validationNumber(rl.charAt(i));
            numList.add(rl.charAt(i));
        }
        if(numList.size()!=3){
            throw new IllegalArgumentException();
        }
        validationDuplicate(numList);
    }

    private void validationDuplicate(List<Character> numList) {
        Set<Character> numSet = new HashSet<>();
        for(char a:numList){
            numSet.add(a);
        }
        if(numSet.size() != numList.size()){
            throw new IllegalArgumentException();
        }
    }

    private void validationNumber(char num){
        if(num < '0' || num > '9'){
            throw new IllegalArgumentException();
        }
    }
    private void printScore() {
        if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        }
        if(ball != 0 && strike == 0){
            System.out.printf("%d볼\n",ball);
        }
        if(ball==0 && strike!=0){
            System.out.printf("%d스트라이크\n",strike);
        }
        if(ball !=0 && strike !=0){
            System.out.printf("%d볼 %d스트라이크\n",ball,strike);
        }
        if(strike==3){

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            selectNewGame();
        }
        ball=0;
        strike=0;
    }

    private void selectNewGame() {
            String ret = readLine();

            if(ret.equals("1")){
                flag=false;
            }
            if(ret.equals("2")){
                flag=false;
                chk=false;
            }
    }

    private void inputCount(String rl,List<Integer> li){
        for(int i=0;i<rl.length();i++){
            int flag = li.indexOf(rl.charAt(i)-'0');
            countBallAndStrike(i,flag);
        }
    }

    private void countBallAndStrike(int i,int flag){
        if(flag!=-1 && flag == i) {
            strike++;
        }
        if(flag!=-1 && flag !=i ) {
            ball++;
        }
    }


}
