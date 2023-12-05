package baseball;

public class Controller {
	Input input;
	Output output;
	Answer answer;
	public Controller(){
		input = new Input();
		output = new Output();
		answer = new Answer();
	}
	public void startGame(){
		output.start();
		while (true){
			output.enterNumber();
			if (answer.checkAnswer(input.getUserInput())) {
				output.endGame();
				if (input.isRestart()) {
					answer.makeAnswer();
					output.result(answer.getResult());
					continue;
				}
				else break;
			}
			output.result(answer.getResult());
		}
	}
}
