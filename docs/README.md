# ⚾︎ 미션 - 숫자 야구

---

## 구현 기능 목록
* * *

### ✔ 컴퓨터 랜덤 숫자 발행 기능
- 정답 숫자를 발행한다.
  - **makeNumber**


### ✔ 컴퓨터 랜덤 숫자 유효성 검사 기능
- 컴퓨터가 만든 숫자가 3개인지 검사한다.
  - **validateNumberSize** 메시지 ➡ 컴퓨터 생성 숫자 (List)
- 컴퓨터가 만든 숫자의 크기가 1~9 사이인지 검사한다.
  - **validateNumberLength** 메시지 ➡ 컴퓨터 생성 숫자 (List)
- 컴퓨터가 만든 숫자에 중복이 있는지 확인한다.
  - **validateDuplicateNumber** 메시지 ➡ 컴퓨터 생성 숫자 (List)

    
### ✔ 사용자 입력 숫자 검증 기능
- 사용자가 입력한 숫자를 검증해 스트라이크, 볼, 낫싱을 계산한다.
  - **verifyNumber** 메시지 ➡ 사용자 입력 숫자 (List)
- 사용자가 입력한 숫자를 검증해 3스트라이크가 되어 게임이 종료되었는지 검증한다.
  - **verifyEnd** 

### ✔ 사용자 입력 숫자 유효성 검사 기능
- 사용자가 입력한 숫자가 3개인지 검사한다.
    - **validateNumberSize**  메시지 ➡ 사용자 입력 숫자 (List)
- 사용자가 입력한 숫자의 크기가 1~9 사이인지 검사한다.
    - **validateNumberLength**  ➡ 사용자 입력 숫자 (List)
- 사용자가 입력한 숫자에 중복이 있는지 확인한다.
    - **validateDuplicateNumber** 메시지 ➡ 사용자 입력 숫자 (List)

### ✔ 메시지 출력 기능
- `숫자 야구 게임을 시작합니다.` 를 출력한다.
  - **printStart**
- `숫자를 입력해주세요 : ` 를 출력한다.
  - **printInsertNumber**
- 숫자가 일치 할 경우`3개의 숫자를 모두 맞히셨습니다! 게임 종료` 를 출력한다.
  - **printCorrect**
- 게임이 끝났을 경우 `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 를 출력한다.
  - **printEnd**
- 사용자 입력에 따른 스트라이크, 볼을 출력한다 ex) `1볼 1스트라이크`
  - **printResult** 메시지 ➡ 스트라이크 (int), 볼 (int)

### ✔ 숫자 야구 게임 실행 기능
- 구현 로직에 맞게 숫자 야구 게임을 실행한다
  - **gameStart**

---
## 클래스 다이어그램
![baseball](https://github.com/study-hub-inu/study-hub-server/assets/97587573/d82209bf-e71b-43ce-bb8a-df20434eb756)
