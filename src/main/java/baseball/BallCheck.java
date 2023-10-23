package baseball;

public class BallCheck {

	public static int check(int[] coms_ball,int[] myball) {
		
		int bcnt = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(coms_ball[i] == myball[j] & i != j) {
					bcnt++;
				}
			}
		}
		return bcnt;
	}
	
}
