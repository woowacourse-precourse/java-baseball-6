package baseball;

public class CompareLogic {

	public boolean nothing(int[] num,int[] insertNum) {
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<insertNum.length;j++) {
				if(num[i]==insertNum[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public int ball(int[] num,int[] insertNum) {
		int count=0;
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<insertNum.length;j++) {
				if(i!=j) {
					if(num[i]==insertNum[j]) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public int strike(int[] num,int[] insertNum) {
		int count=0;
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<insertNum.length;j++) {
				if(i==j) {
					if(num[i]==insertNum[i]) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
