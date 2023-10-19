# 과제1 - 숫자야구

## 📝 기능목록

---

### 💻 컴퓨터 기능

- 3자리 숫자를 무작위로 선택한다 : `selectNum()`
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
        - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
        - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    - 사용 예시


- 게임 시작마다 새로 숫자 선택

---

### 🃏 게임 진행자 기능

- 게임 시작 문구 출력 : `startGame()`


- 게임 진행 : `playGame()`
    - 숫자 판단
    - 결과 출력
    - 정답 & 게임 종료
        - 사용자 - 게임 재시작&종료 선택

---

### 👨‍💻 사용자 기능

- 숫자 입력 : `insertNum()`


    - 게임 진행자 - 게임 진행
    - 정답 맞출 때까지 반복해서 입력
- 게임 재시작 & 종료 선택 : `OnceAgain()`
    - 1 : 재시작
    - 2 : 게임 종료