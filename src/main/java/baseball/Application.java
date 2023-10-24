package baseball;

public class Application {
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();

        while(gameMaster.isGameInProgress()) {
            Computer computer = new Computer();
            gameMaster.init();
//            System.out.println(computer.getRandomNumber());
            gameMaster.start();
            while(!gameMaster.findCorrectAnswer()) {
                Validator validator = new Validator(computer.getRandomNumber());
                String answer = gameMaster.progress();
                validator.writeBaseballAnswer(answer);

                validator.init();
                validator.changeInputBaseballType();
                String s = gameMaster.printResult(validator.calculateResult());

                String decide = gameMaster.checkResult(s);
                if(decide != null) {
                    String decideAnswer = validator.writeProgressAnswer(decide);
                    gameMaster.conclude(decideAnswer);
                }
            }
        }
    }
}
