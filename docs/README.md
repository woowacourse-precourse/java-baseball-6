### Model

- GameNumber
    - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 저장하기 위한 객체 생성

### View

- InputView
    - 사용자가 숫자를 입력하기 위한 View생성
- OutputView
    - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교한 후, 결과를 출력하기 위한 View생성

### Controller

- ComputerController
- RandomController
    - 컴퓨터는 서로 다른 세자리의 숫자를 생성한다.
- GameController
    - 컴퓨터가 생성한 숫자와 사용자가 입력한 숫자를 비교한다.
    - 3스트라이크일 경우, 게임 종료를 하도록 구현한다.
    - 1과 2중 하나를 입력하여, 다시 게임을 진행할지 여부를 판단한다.
- ValiationController
    - 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자 모두 서로다른 세자리의 숫자로 이루어졌는지에 대한 유효성을 검사한다.