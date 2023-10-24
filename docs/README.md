# Mission
우아한 테크코스 1주차 프리코스 미션 - 숫자야구



---------------
### 개발 환경
- `Java 17.0.9`
- `Eclipse`
 
### 개발 작업
- Application.java 의 main에서 작동
- BaseballGame을 위한 interface작성
```
 startGame();
 endGame();
```
- BaseballGameImpl에 필요한 메서드 구현
```
startGame()        : computer의 난수값 설정 -> 숫자입력 -> 각종 체킹 -> 정답 시 break;
endGame()          : 1입력 시 새로운 게임 시작 || 2입력 시 게임 종료
```
-GameItem을 위한 interface작성
```
 computer();
 checkForStrikes();
 showStrikeAndBall();
 isDuplicated();
 validateLength();
```
-GameItemImpl에 필요한 메서드 구현
```
 computer           : 컴퓨터의 난수 3자리 값 생성
 checkForStrikes    : 입력 받은 숫자에서 strike와 ball을 분별
 showStrikeAndBall  : strike나 ball또는 낫싱의 값을 출력
 isDuplicated       : 입력 받은 숫자에서 중복값 체크 ( 중복 시 IllegalArgumentException 투척)
 validateLength     : startGame()`내에 잘못된 값 입력시 IllegalArgumentException 투척
--------------
