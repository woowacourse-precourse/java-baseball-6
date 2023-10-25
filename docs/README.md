Application 클래스 : 프로그램 실행 클래스
- main : 프로그램 실행
- 
GameNumber 클래스 : 게임에 필요한 수를 다루는 클래스
- generateComputerNumber : 컴퓨터 랜덤 번호 생성한다
- convertUserNumber : 입력 받은 유저 넘버을 나누고 변환해준다

GamePlayer 클래스 : 게임의 전체 과정 로직을 다루는 클래스
- playGame - 게임 전체가 플레이되는 메소드
- playRound - 유저가 번호를 제시하고 점수를 확인받는 한 라운드가 실행되는 메소드

GameScore 클래스 : 유저와 컴퓨터의 값으로 strike 와 ball 을 계산하는 클래스
- calculateStrike : strike 계산
- calculateBall : ball 계산

GameStatus 클래스 : 게임의 상태를 다루는 클래스
- checkGameSuccess : 유저가 3스트라이크에 성공하였을 시 성공상태로 만들어준다 
- checkGameStatusDecision : 유저가 새로운 게임을 할지 종료할지 판단한 결과에 따라 게임 상태를 만들어준다
- isGameSuccessStatus : 현재 게임 상태가 성공 상태인지 판별해준다.
- isEndStatus : 현재 게임 상태가 종료 상태인지 판별해준다.

Input 클래스 : console 로 입력을 받는 클래스
- inputData : 입력을 호출하는 메서드
- inputUserNumber : 유저 번호 입력
- inputGameStatusDecision : 유저가 새로운 게임을 할지 종료할지 입력

Output 클래스 : 결과를 알리는 클래스
- startGame : 게임 시작을 알린다, 게임 진행 상태값을 반환한다.
- printRoundScore : 한 라운드에 점수를 알린다
- printGameSuccessMessage : 게임을 성공했음을 알린다

Validator클래스 : input 값 유효성검사 클래스
- validateInputData : 숫자로 변환 가능한 값인지 검사, 예외 발생
- validateUserNumber : 유저 넘버 검사, 예외 발생
- isUserNumberOutOfRange : 유저 넘버 범위 판단
- isUserNumberOverlap : 유저 넘버 중복 판단
- validateGameStatusDecision : 유저가 새게임 할지 종료할지 입력한 값 검사, 예외 발생
- isGameStatusDecisionMismatch : 유저가 새게임 할지 종료할지 입력한 값 에 일치하는 값인지 판단