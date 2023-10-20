
# 기능 목록
1. 게임 시작 문구 출력
2. 무작위로 뽑은 1에서 9까지 서로 다른 3개의 숫자로 구성된 문자열(randomNumber) 생성 
3. 사용자로부터 서로 다른 세 자리 수의 문자열(inputNumber)을 입력 받음
4. 사용자 입력 유효성 검사
   5. 유효하지 않은 입력을 받았다면, IllegalArgumentException 발생시키고, 프로그램 종료
5. inputNumber의 각 숫자를 randomNumber의 모든 숫자와 비교하며,
   6. 같은 수가 같은 자리에 있으면 스트라이크 개수(strikeCount)를 증가
   7. 같은 수가 다른 자리에 있으면 볼 개수(ballCount)를 증가
8. strike와 ball의 값에 따라,
   9. strikeCount가 3이라면, "3스트라이크"를 출력 후, (7)로
   10. strikeCount와 ballCount 모두 0이라면, "낫싱"을 출력 후, (3)으로
   11. 그 외에는, "{ballCount}볼 {strikeCount}스트라이크"를 출력 후, (3)으로
12. 게임 종료 문구 출력
13. 시용자로부터 게임 재진행 의사를 입력 받음
    14. 1: (3)으로 이동
    15. 2: 프로그램 종료

# 기능 목록에 따른 클래스 추출
1. BaseballGame: 게임 문구 (시작, 종료, 재시작 등..) 출력과 게임 루틴 (문자열 비교, 볼, 스트라이크 개수 파악 및 출력)
2. Player: 사용자 입력 처리
3. RandomNumberGenerator: 1에서 9까지 서로 다른 3개의 숫자로 구성된 문자열 생성 및 관리
   4. 랜덤 문자열을 생성할 때, 문자열에 무작위로 생성된 수를 기존 문자열에 존재하는지 비교하고 삽입
   5. 숫자를 비교해서 마지막에 숫자를 문자열로 바꾸기


# RandomNumberGenerator 구현
1. 무작위 수를 중복 없이 문자열에 추가 후 반환
   2. 을 생성하고, 무작위로 생성된 1 ~ 9 사이의 수를 중복을 확인하면서 추가
3. 무작위 수를 정수형에 중복을 확인하고 추가 후 문자열로 변환 후 반환
```Java
public class RandomNumberGenerator {
    int digitCount;
    public RandomNumberGenerator(){
        this.digitCount = 3;
    }
    public String generateRandomNumber(){
        int randomNumber = 0;

        while (randomNumber < (int) Math.pow(10, this.digitCount - 1)){
            int randomDigit = pickNumberInRange(1, 9);

            if (!checkRedundancy(randomNumber, randomDigit)){
                randomNumber = (randomNumber * 10) + randomDigit;
            }
        }
        return Integer.toString(randomNumber);
    }

    private boolean checkRedundancy(int randomNumber, int randomDigit){
        while (randomNumber != 0){
            if ((randomNumber % 10) == randomDigit){
                return true;
            }
            randomNumber = randomNumber / 10;
        }
        return false;
    }
}
```
