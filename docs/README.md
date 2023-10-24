# 구현할 기능 목록
<hr/>

### GameStarter 클래스

> 각 게임을 시작하게 하는 클래스
> > 필드:
> > + ArrayList computer: 컴퓨터의 숫자 저장
> > + boolean isGameOver: 게임이 끝났는지 여부 저장, 초깃값은 false

##### GameStarter() 생성자
+ 컴퓨터의 세자리 숫자를 랜덤으로 결정함.
+ 각 자리는 1~9 범위이며, 중복은 허용되지 않음.

##### void startGame()
+ isGameOver가 true가 될 때까지 startRound를 반복함.
+ startRound에서 에러가 발생한다면 던짐.
+ isGameOver가 true가 되어 게임이 끝나면 게임 종료 문구 출력.

##### void startRound()
+ 사용자에게 숫자를 입력받고 checkInputValidity를 호출함.
+ checkInputValidity에서 에러가 발생한다면 던짐.
+ 입력받은 숫자와 컴퓨터의 숫자를 비교하기 위해 compareNum을 호출함.

##### void compareNum(personNum)
+ 컴퓨터의 숫자와 사용자에게 입력받은 숫자를 비교해 ball과 strike의 개수를 구함.
+ 이 과정에서 isBall과 isStrike를 호출함.
+ printResult를 호출함.
+ 만약 strike가 3이라면 isGameOver를 true로 바꿈.

##### int isBall(num, index)
+ 해당 숫자가 strike가 아닌 ball이라면 1을 반환
+ strike이거나 ball이 아니라면 0을 반환

##### int isStrike(num, index)
+ 해당 숫자가 strike라면 1을 반환
+ strike가 아니라면 0을 반환

##### void printResult(ball, strike)
+ ball과 strike의 개수에 따라 다른 결과를 출력함.

##### checkInputValidity(personNum)
+ 사용자에게 입력받은 값이 유효한지 판단함.
+ 입력값이 3자리 수가 아니라면 에러를 발생시킴.
+ 입력값에 중복되는 수가 있다면 에러를 발생시킴.

<br/>

### Application 클래스
> 프로그램을 시작시키는 클래스 (메인 메소드 포함)

##### main 메소드
+ gameReplayIf1 변수를 정의하고 초깃값을 1로 설정함.
+ 게임 시작 문구를 출력함.
+ gameReplayIf1이 1이 아닐 때까지 GameStarter 클래스의 인스턴스를 생성하고 startGame을 호출함.
+ 각 게임이 끝난다면 게임 리플레이 문구를 출력하고 숫자를 입력받음.
+ 입력받은 수가 1또는 2가 아니라면 에러를 발생시킴.
+ startGame 또는 리플레이 입력에서 에러가 발생한다면 던짐.





