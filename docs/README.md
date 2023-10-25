기능 구현

* 게임에 접근할 수 있는 GameController
# controller 분리 이유 : 지금은 3자리 숫자만을 사용하지만 사용자의 요구에 따라 config를 주기 위함

- 생성자를 통한 게임 시작 알림 기능
- gameStart() - GameService 클래스의 execute 실행



* 게임의 전체적인 서비스를 관리하는 GameService

depends -

랜덤 수를 생산하는 NumberGenerator
- getBall()
- 3자리의 볼을 생성하는 함수
- randomNum()
- 생성된 3자리 함수에 자리수를 부여

input을 담당하는 InputManager
- getBallNumber()
  - Console.readLine()을 통해 수를 입력 받고 validation 실행
- validate()
  - 입력조건에 맞지 않을 경우 IllegalArgumentException 


계산 로직을 담당하는 GameCalculator
- getResult()
  - ballCount와 strikeCount를 계산해준다.

- GameService 수행시나리오
    - numberGenerator를 통해 randomNumber 생성
    - inputManager를 통해 사용자 입력 받아드림
    - gameCalculator가 ball strike 개수 계산
    - 게임이 끝날 경우 사용자의 입력을 받아 다시 execute를 재귀적 실행
    - 게임이 끝나지 않을 경우 showDetails를 보여주며 while문 진행




