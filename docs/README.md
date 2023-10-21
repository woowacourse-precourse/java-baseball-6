## 도메인
- MyNumbers : 사용자가 입력한 숫자들을 int 필드로 저장하는 VO
- Info : MyNumbers 객체와 ComputerNumbers 를 동일성 비교하여 정보를 넘기는 VO
- ComputerNumbers : 게임 시작 직후, 컴퓨터가 만든 무작위 숫자들을 int 필드로 저장하는 VO
- Game : 게임이 시작될 때 생성되는 객체

## 뷰
- InputView : 사용자의 입력값을 받는 뷰
    - inputNumbers() : 숫자 입력
    - inputRestartOrExit() : 게임 재시작 또는 종료 여부 입력
- OutputView : 로직의 출력값
    - "?볼 ?스트라이크"
    - "?스크라이크"
    - "낫싱"
    - "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
- MyNumbers : 사용자가 입력한 숫자들
    - compareNumbers() : MyNumbers 객체와 ComputerNumbers 동일성 비교하여 Info 객체를 적절히 생성 후 반환
- Game
    - startGame() : Game객체가 생성되고 ComputerNumbers 객체 생성부터 OutputView 로직을 모두 담음

## 컨트롤러
- GameController : InputView 부터 OutView 로직까지 모두 포함

## 예외
- 사용자가 사이즈 4 이상의 숫자를 입력한 경우
- 사용자가 숫자가 아닌 값을 입력한 경우
- 사용자가 중복된 숫자를 입력한 경우
- 게임 재시작(1) 또는 종료(2) 이외의 값을 입력한 경우