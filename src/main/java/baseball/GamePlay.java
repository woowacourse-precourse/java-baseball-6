package baseball;

	import camp.nextstep.edu.missionutils.*;
	
	import java.util.List;
	
	
public class GamePlay {
	IllegalDetector detector = new IllegalDetector();
	
	AnswerGenerator answers = new AnswerGenerator();
	
	PlayerInputAccepter player = new PlayerInputAccepter();
	
	PrintMessage print = new PrintMessage();
	
	String Gameplay = "1";
	
	boolean correct;
	int ball = 0;
	int strike = 0;
	
	public GamePlay() { 
		while(Gameplay.equals("1")) {
			answers.RandomNumGeneration();
			correct = false;
			
			while(!correct) {
				print.InputMessage();
				player.ReadNumber();
				detector.InitialInputLengthDetector(player.ReadNum);
				player.InputUserNum(player.ReadNum);
				detector.RedundantDetector(player.PlayerInput);
				Gameplay(answers.Answerlist, player.PlayerInput);
			}
		}
	}
	
	public void Gameplay(List<Integer> answer,List<Integer> UserNums) {
			CountBall(answer, UserNums);
			CountStrike(answer, UserNums);
			Result();
		}
	
	public void CountBall(List<Integer> answer,List<Integer> UserNums) {
		for(int i = 0; i < 3; i++) {
			if(answer.contains(UserNums.get(i))){
				ball++;
			}
		}
	}
	
	public void CountStrike(List<Integer> answer,List<Integer> UserNums) {
		for(int i = 0; i < 3; i++) {
			if(answer.get(i).equals(UserNums.get(i))){
				strike++;
				ball--;
			}
		}
	}
	public void InitialCount() {
		ball = 0;
		strike = 0;
	}
	public void Result() {
		print.ResultMessage(ball,strike);
		
		if(strike == 3) {
			print.RestartMessage();
			CheckContinueGame();
			detector.GameplayDetector(Gameplay);
			correct = true;
		}
		
		InitialCount();
		}
	
	public void CheckContinueGame() {
		Gameplay = Console.readLine();
	}
	
	
	
}