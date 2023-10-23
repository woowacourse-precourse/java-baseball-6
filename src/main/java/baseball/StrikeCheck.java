package baseball;

public class StrikeCheck {

	public static int check(int[] coms_ball, int[] myball) {

		int stcnt = 0;
		
		for(int i=0; i<3; i++) {
			if(coms_ball[i] == myball[i]) {
				stcnt++;
			}
		}
		return stcnt;
		
	}
	
}
