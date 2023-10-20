# 🥎숫자 야구⚾️
1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

## 기능 목록
```🌱 Domain```
- Computer
  - 컴퓨터(상대방)의 숫자 설정 관련 담당
- Player
  - 플레이어의 숫자를 설정 관련 담당
<br>
<br>


```🌱 Service```
- GameFlowManagementService
  - 숫자 야구 게임의 흐름 및 다음 게임의 'Replay or Quit' question 담당

- GameNumberCheckService
  - 컴퓨터와 플레이어의 숫자 비교 담당
    - '스트라이크, 볼'을 카운트
<br>
<br>

```🌱 Controller```
- BaseballGameController
  - 숫자 야구 게임의 전체 play 결정 담당
    - '컴퓨터의 숫자'와 'View를 통해 가져온 플레이어의 입력 숫자'를 비교한다.
    - 게임을 종료한 경우, 다음 게임 Replay or Quit 실행하는 것을 결정한다.
    - 이 곳에서는 요청에 따른 결정만 진행하며, 실제 처리는 Sevice에서 진행된다.
<br>
<br>

```🌱 Util```
- ComputerNumberGenerator
  - 숫자 야구 게임의 컴퓨터(상대방) 랜덤 숫자 생성 담당
    - 플레이어가 랜덤 숫자를 생각해 고르는 것처럼, 컴퓨터의 랜덤 숫자를 생성한다.

- StringToArrayList
  - String 숫자의 ArrayList 변환 담당
    - String 형태로 입력되어 들어오는 숫자를 ArrayList 형태로 변환하여 1~9의 숫자를 정확히 파악한다.
<br>
<br>

```🌱 View```
- FirstGamePlayerInputView
  - 플레이어의 숫자 입력 처리 담당
    - 플레이어의 입력을 실제로 받고, 입력을 save한다.

- NextGamePlayerInputView
  - **이전 게임 종료 후, 다음에 이어지는 게임**에서의 플레이어 숫자 입력 처리 담당
    - 플레이어의 입력을 실제로 받고, 입력을 save한다.

- GameScoreView
  - 숫자 야구 게임의 플레이 상황에 따른 적절한 결과 출력 담당
    - 게임 정상 종료 후, 게임의 결과와 Replay or Quit 여부를 출력한다.
  ```
  1볼 1스트라이크
  ```
  
  ```
  낫싱
  ```
  
  ```
  3스트라이크 
  3개의 숫자를 모두 맞히셨습니다! 게임 종료
  ```

  ```
  숫자 야구 게임을 시작합니다.
  ```
  
  ```
  게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
  ```
<br>
<br>

```🌱 Exception```
- PlayerInputException
  - 숫자 야구 게임을 위해 플레이어가 입력한 값에 대한 예외 처리 담당
    - 숫자의 중복 여부를 체크한다.
    - 숫자가 아닌 입력 및 숫자의 입력 개수를 체크한다.
      - 문자, 특수문자 등 숫자를 제외한 입력을 할 경우
      - 개수의 미만, 초과 발생
    - 숫자의 범위 초과 여부를 체크한다.

- ReplayOrQuitGameException
  - 앞선 숫자 야구 게임의 종료 후, Replay or Quit을 위해 플레이어가 입력하는 값에 대한 예외 처리 담당
    - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."의 답변에서의 예외를 처리한다.
      - 1,2가 아닌 숫자를 입력한 경우 체크
      - 숫자를 여러 개 입력한 경우 체크