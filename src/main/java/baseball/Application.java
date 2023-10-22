package baseball;

public class Application {
    static Game game = new Game();
    public static void main(String[] args) {
        game.startGame();
        game.setGame();
       while (true){
           playGame();
           game.endGame();
           if(game.reStart() == 2){
               System.out.println("게임 종료");
               break;
           }
           else{
               reStartGame();
           }
       }


    }
    public static void playGame(){

        while(!game.isOver()){
            game.inputNum();
            game.check_num();
            game.printResult();
        }

    }
    public static void reStartGame(){
        game.setGame();
        game.setStrikeAndBall();
    }
}