## 도메인
- ClientNumbers : 사용자가 입력한 숫자들을 int 필드로 저장하는 VO
- ComputerNumbers : 게임 시작 직후, 컴퓨터가 만든 무작위 숫자들을 int 필드로 저장하는 VO
- Info : MyNumbers 객체와 ComputerNumbers 를 비교하고 계산하여 ball, strike, ongoing 정보를 저장한다
- Game : 게임이 시작될(재시작 포함) 때 생성되는 객체

## 뷰
- InputView : 사용자의 입력값을 받는 뷰
    - makeClientNumbers : 입력값을 받아 ClientNumbers 객체 생성하는 메서드
    - validate...() : 입력값 검증 메서드
- OutputView : 경우에 따른 메시지 출력하는 뷰
    - printStartMsg() : "숫자 야구 게임을 시작합니다."
    - printBallAndStrikeMsg() : "?볼 ?스트라이크" 
    - printBallMsg() : "?볼"
    - printStrikeMsg() : "?스크라이크"
    - printNothingMsg() : "낫싱"
    - printSuccessMsg() : "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    - printRestartOrExitMsg() : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
- ClientNumbers : 사용자가 3개의 숫자를 입력할 때마다 그 숫자들을 저장하고 관리하는 클래스
    - getNumbers() : private final List<Integer> numbers 반환하는 메서드
    - compareWithComputerNumbers() : ClientNumbers 객체와 ComputerNumbers 동일성 비교하여 Info 객체를 적절히 생성 후 반환
- ComputeNumbers : 게임이 시작될 때마다 랜덤으로 3개의 숫자를 선택하여 그 숫자들을 저장하고 관리하는 클래스
    - getNumbers() : private final List<Integer> numbers 반환하는 메서드
    - ComputerNumbers() : missionutils.Randoms 를 사용하여 a 부터 b 까지의 수 중에서 중복되지 않고 무작위 n개의 숫자를 선택하여 List<Integer> 반환하는 메서드
- Game
    - startGame() : 게임 시작을 알리는 메시지 출력하는 메서드
    - proceedGame() : 게임의 메인 로직이 구현된 메서드
      - 게임이 시작될 때마다 ComputerNumbers 객체가 생성된다
      - 사용자가 입력할 때마다 ClientNumbers 객체가 생성된다
      - ComputerNumbers 객체와 ClientNumbers 객체를 비교하여 게임을 승리할 수 있도록 힌트를 준다 (OutputView 메서드 사용)
    - restartOrExitGame() : 게임이 승리한 이후 재시작할 것인지 종료할 것인지 묻는 메서드
      - 만약 1 을 입력한다면 게임 재시작 proceedGame()
      - 만약 2 를 입력한다면 게임 종료 (플래그 oneMore = false 설정)
      - 2 를 입력하기 전까지 while 반복

## 컨트롤러
- GameController : Game 객체의 메서드를 통제하는 클래스
  - startGame(), proceedGame(), restartOrExitGame() 

## 예외
- 사용자가 입력한 숫자의 개수가 3이 아닌 경우
- 사용자가 숫자가 아닌 값을 입력한 경우
- 사용자가 중복된 숫자를 입력한 경우
- 게임 재시작(1) 또는 종료(2) 이외의 값을 입력한 경우