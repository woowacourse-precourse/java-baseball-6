package baseball;

import camp.nextstep.edu.missionutils.Console;
 public class Game{
     private int strike;
     private int ball;
     User user = new User();
     Computer computer = new Computer();
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void setGame(){
        computer.clearComputer();
        computer.setComputer();
    }
    public void inputNum() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        user.clearUser();
        user.setUser();
    }
    public void setStrikeAndBall(){
        this.ball =0;
        this.strike =0;
    }

   public void check_num(){
        setStrikeAndBall();
       for(int idx_computer =0; idx_computer < computer.getComputer().size(); idx_computer++){
           for(int idx_user =0; idx_user < user.getUser().size(); idx_user++){
               if(computer.getComputer().get(idx_computer) == user.getUser().get(idx_user)){
                   if(idx_computer == idx_user){
                       this.strike +=1;
                   }else{
                       this.ball +=1;
                   }
               }
           }
       }
    }

    public void printResult(){
        if(this.strike == 0 && this.ball == 0){
            System.out.println("낫싱");

        }

        if(this.strike == 0 && this.ball != 0){
            System.out.println(this.ball +"볼");

        }

        if(this.strike != 0 && this.ball == 0){
            System.out.println(this.strike +"스트라이크");

        }

        if(this.strike != 0 && this.ball != 0){
            System.out.println(this.ball +"볼 "+this.strike+"스트라이크");
        }


    }
   public boolean isOver(){
        if(this.strike == 3){
            return true;
        }
        return false;
   }

   public int reStart() throws  IllegalArgumentException{
        int command = Integer.parseInt(Console.readLine());

        if(command >2 || command <=0){
            throw new IllegalArgumentException();
        }
        return command;
   }

   public void endGame(){
       System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
       System.out.println("게임을 새로 시작 하려면 1, 종료하려면 2를 입력하세요.");

   }




}
