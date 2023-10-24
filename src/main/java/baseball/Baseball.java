package baseball;

public class Baseball {
	public Boolean play(String computerInput, String userInput){
		int ball = 0;
		int strike = 0;
		char[] computer = computerInput.toCharArray();
		char[] user = userInput.toCharArray();

		for(int c = 0; c < computer.length; c++){
			for(int u = 0; u < user.length; u++){
				if(c == u && computer[c] == user[u]){
					strike++;
				} else if(computer[c] == user[u]){
					ball++;
				}

			}
		}

		String result = "";
		if(ball != 0){
			result += ball+"볼";
			result += " ";
		}
		if(strike != 0){
			result += strike+"스트라이크";
		}
		if(ball == 0 && strike == 0){
			result += "낫싱";
		}

		System.out.println(result);
		if(strike == 3){
			return true;
		}
		return false;
	}

}
