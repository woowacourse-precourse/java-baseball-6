package baseball;
import java.util.List;

import camp.nextstep.edu.missionutils.*; 
public class GamePlay {
	IllegalDetector detector = new IllegalDetector();
	AnswerGenerator answers = new AnswerGenerator();
	PlayerInputAccepter player = new PlayerInputAccepter();
	
	String Gameplay = "1";
	boolean correct;
	int ball = 0;
	int strike = 0;
	public GamePlay() { 
		while(Gameplay.equals("1")) {
			answers.RandomNumGeneration();
			correct = false;
			while(!correct) {
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
		StringBuilder resultMessage = new StringBuilder();
		if(ball == 0 && strike == 0)
			resultMessage.append("낫싱");
		if(ball != 0)
			resultMessage.append(ball).append("볼").append(" ");
		if(strike != 0)
			resultMessage.append(strike).append("스트라이크");
		System.out.println(resultMessage.toString().trim());
		if(strike == 3) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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