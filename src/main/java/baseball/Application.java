package baseball;

public class Application {
    static Game game = new Game();
   static boolean check_error = false;
    public static void main(String[] args) {
        game.startGame();
        game.setGame();
        while (true){
            playGame();
            if(check_error){
                break;
            }
            game.endGame();
            try{
                int reStartCommand = game.reStart();
                if(reStartCommand== 2){
                    System.out.println("게임 종료");
                    break;
                }
                else if(reStartCommand == 1){
                    reStartGame();
                }
            }catch(IllegalArgumentException e){
                throw e;

            }

        }


    }
    public static void playGame(){

        while(!game.isOver()){
            try{
                game.inputNum();
            }catch (IllegalArgumentException e){
               throw e;
            }
            game.check_num();
            game.printResult();
        }

    }
    public static void reStartGame(){
        game.setGame();
        game.setStrikeAndBall();
    }
}