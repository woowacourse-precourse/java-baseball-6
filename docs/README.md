# ver 1. 구현

### 목표

- Application.class 안에 게임 진행에 필요한 모든 로직을 구성하여 주어진 기능 테스트를 통과한다.

### 구현 목록

- main() : 컨트롤러 역할
- illegalArgument() : 주어진 입력값의 무결성 확인
- correct() : 주어진 입력값이 정답과 동일한지 확인
- printScore() : correct()에서 확인한 결과 출력
- generateRandom() : missionUtils.Randoms를 활용해 임의의 정답 생성

# ver 2. 구현

### 목표

- ver 1.에서 구현한 로직을 해체하여 역할에 맞게 분리한다.

### 구현 목록

- 어플리케이션
    - Application : BaseballGame에 어플리케이션 시작과 종료를 위임한다.
- 컨트롤러
    - BaseballGame : 어플리케이션의 시작과 종료 시점을 담당하며, GameService에 게임 진행을 위임한다.
- 서비스
    - GameService : 랜덤값과 입력값을 비교하여 게임의 진행을 결정하는 핵심 로직을 담당하며, 값 생성 및 입력에 대해서는 NumberService에 위임한다.
    - NumberService : 랜덤값을 생성하고 사용자로부터 입력값을 받은 후에 무결성을 확인한다.
    - PrintService : 게임 진행 전반에 등장하는 메시지를 출력한다.
- 도메인
    - StringConstant : 게임 진행 상황에 맞는 메시지 및 문자열을 담는다.
    - NumberConstant : 게임 진행에 필요한 상수를 담는다.
    - ErrorConstant : NumberService에서 입력값의 무결성을 확인하는 과정에 필요한 에러 메시지를 담는다.