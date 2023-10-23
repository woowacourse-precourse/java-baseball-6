package baseball;

public class Application {
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();

        while(gameMaster.shouldContinueRound) {
            Computer computer = new Computer();
            gameMaster.init();
//            System.out.println(computer.randomNumber);
            gameMaster.start();
            while(!gameMaster.isCorrectAnswerFound) {
                gameMaster.progress();

                Validator validator = new Validator(computer.randomNumber, gameMaster.inputNumber);
                validator.init();
                validator.changeInputBaseballType();
                String s = gameMaster.printResult(validator.calculateResult());

                String decide = gameMaster.checkResult(s);
                if(decide != null) {
                    gameMaster.shouldContinueRound = validator.answerOfProgress(decide);
                    gameMaster.isCorrectAnswerFound = true;
                }
            }
        }
    }
}
