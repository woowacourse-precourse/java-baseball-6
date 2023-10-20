## ✏️ 기능 구현 목록 정리하기

### Model
- [ ] Computer Model
  - 컴퓨터가 랜덤으로 생성하는 숫자 3개의 데이터를 저장 및 반환
- [ ] User Model
  - 사용자가 입력한 숫자 3개의 데이터를 저장 및 반환
  - 사용자의 볼과 스트라이크 데이터를 저장 및 반환
  - 컴퓨터의 숫자와 비교해서 볼과 스트라이크 데이터를 변경
---

### View
- GameView
  - [ ] 게임 시작 공지를 출력하는 기능
  - [ ] 사용자의 숫자를 입력받는 기능
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
  - [ ] 게임 결과를 출력하는 기능
  - [ ] 게임 종료를 출력하고 재시작 여부를 입력받는 기능
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
---

### Controller
- Computer Controller
  - [ ] 1부터 9까지 중 무작위의 숫자 3개를 저장하는 기능 
    - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
  - [ ] 사용자와 컴퓨터의 게임 결과를 비교하기 위해 저장된 숫자 정보를 추출하는 기능
- User Controller
  - [ ] 입력받은 UserNumbers를 저장하는 기능
  - [ ] 컴퓨터와 사용자의 게임 결과를 계산하는 기능
  - [ ] 사용자의 볼과 스트라이크 정보를 추출하는 기능
  - [ ] 사용자가 정답을 맞추었는지 확인하는 기능
  - [ ] 재시작 시 사용자의 볼과 스트라이크 정보를 초기화하는 기능
---

### Utility
- InputDataExceptionHandler
  - [ ] 입력받은 사용자 숫자를 검증하는 기능
  - [ ] 입력받은 재시작 여부를 검증하는 기능
---

### Main
- Application
  - <b>MVC 패턴을 활용해서 프로그램을 구현</b>
  - 게임 시작
  - 컴퓨터를 생성하고 번호를 할당
  - 사용자를 생성하고 사용자 번호를 입력
  - 사용자 번호에 대해 컴퓨터 번호와 일치하는지 계산
  - 사용자 번호와 컴퓨터 번호에 대한 결과 출력
  - 재시작 여부에 따른 게임 재시작 및 종료