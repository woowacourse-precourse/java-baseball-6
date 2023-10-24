package baseball.model;

public class Checksum {
	private final Game_logic game_logic;

	public Checksum() {
		game_logic = new Game_logic();
	}

	public int[] getNumberCompare(String Com_Number, String Player_Number) {
		return game_logic.getScore(Com_Number, Player_Number);
	}
	
	// 답 체크 메서드
	public boolean isAnswer() {
			if (game_logic.getstrike() == 3) {
				return true;
			}
			return false;
		}

}
