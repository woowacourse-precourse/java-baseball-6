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
	
	public GamePlay() { //게임 동작 logic
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
	
	public void Gameplay(List<Integer> answer,List<Integer> UserNums) {//게임 진행
			CountBall(answer, UserNums);
			CountStrike(answer, UserNums);
			Result();
		}
	
	public void CountBall(List<Integer> answer,List<Integer> UserNums) {//볼 count
		for(int i = 0; i < 3; i++) {
			if(answer.contains(UserNums.get(i))){
				ball++;
			}
		}
	}
	
	public void CountStrike(List<Integer> answer,List<Integer> UserNums) {//스트라이크 count
		for(int i = 0; i < 3; i++) {
			if(answer.get(i).equals(UserNums.get(i))){
				strike++;
				ball--;
			}
		}
	}
	
	public void InitialCount() {// ball과 strike count 초기화
		ball = 0;
		strike = 0;
	}
	
	public void Result() {// 스트라이크와 볼에 따른 결과 출력
		print.ResultMessage(ball,strike);
		
		if(strike == 3) {
			print.RestartMessage();
			CheckContinueGame();
			detector.GameplayDetector(Gameplay);
			correct = true;
		}
		
		InitialCount();
		}
	
	public void CheckContinueGame() {//게임 종료 후 1과 2중 하나를 받음
		Gameplay = Console.readLine();
	}
	
	
	
}