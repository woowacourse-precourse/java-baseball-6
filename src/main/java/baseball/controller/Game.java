package baseball.controller;

import baseball.model.*;
import baseball.view.*;

public class Game {
	private static Player_Number player;
	private final Com_Number computer;
	private final Checksum checksum;

	public Game() {
		computer = new Com_Number();
		checksum = new Checksum();
	}

	public void start() {
		do {
			getPlayer_Number();
			printscore(getScore());

		} while (!checksum.isAnswer());
	}

	// 뷰에서 값 받아오기
	public void getPlayer_Number() {
		player = new Player_Number(input_View.inputPlayerNumber());
		player.getPlayer_Number();
	}
	//
	public int[] getScore() {
		return checksum.getNumberCompare(player.getPlayer_Number(), computer.getCom_Number_Str());
	}
	// 점수 출력 메서드
	public void printscore(int[] score) {
		printBallscore(score);
		printStrikescore(score);
		printNothing(score);
	}
	// 볼 수 출력
	public static void printBallscore(int[] score) {
		if (score[0] != 0) {
			if (score[1] != 0) {
				output_View.Score(score[0]);
				output_View.Ball_StrikeMessage();
			} else {
				output_View.Score(score[0]);
				output_View.Ball_Message();
			}

		}
	}
	// 스트라이크 수 출력
	public static void printStrikescore(int[] score) {
		if (score[1] != 0) {
			output_View.Score(score[1]);
			output_View.Strike_Message();
		}
	}
	// 낫싱 출력
	public static void printNothing(int[] score) {
		if (score[0] == 0 && score[1] == 0) {
			output_View.Nothing_Message();
		}
	}

}
