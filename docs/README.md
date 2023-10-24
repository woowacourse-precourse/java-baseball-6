# 숫자 야구 ⚾︎

***

## 🎮 게임 진행

> **1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임**

1. 게임 시작  
   `숫자 야구 게임을 시작합니다.`
   <br/><br/>
2. _서로 다른 3자리의 수_ 를 입력  
   `숫자를 입력해주세요 : `
   <br/><br/>
3. _컴퓨터가 선택한 숫자_ - _user가 입력한 숫자_ 비교 후 결과 출력
    - **스트라이크** : 같은 수 & 같은 자리
    - **볼** : 같은 수 & 다른 자리
    - **낫싱** : 전부 다른 수  
      ex) `1볼 1스트라이크` `2볼` `낫싱`
      <br/><br/>
4. `3스트라이크`  → 종료  
   `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
   <br/><br/>
5. 게임을 다시 시작하거나 완전 종료  
   `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
   <br/><br/>
   <br/>

## 🕹 기능 목록

### 1. _GameControl Methods_

- <code>**startGame**</code>
    - _게임 시작_ 과 _완전 종료_ 를 제어
    - _restart_ 여부 확인
        - 다시 시작
        - 완전 종료
          <br/><br/>
- <code>**baseballGame**</code>
    - _숫자 야구 게임_ 한 판의 시작부터 종료까지 제어
    - _3 스트라이크_ 일 시 게임 종료
      <br/><br/>

### 2. _Input Methods_

- <code>**getComNums**</code>
    - 랜덤으로 _정답이 될 3자리 서로 다른 숫자_ 를 생성 후 _List\<Integer>_ 반환
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` API 사용
      <br/><br/>

- <code>**getUserNums**</code>
    - user에게 입력을 받아 _List\<Integer>_ 로 변환하여 반환
    - _validate 메소드_ 호출하여 유효성 검사 진행
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API 사용
      <br/><br/>

### 3. _Utility Methods_

- <code>**compareNums**</code>
    - _comNums_ 와 _userNums_ 비교하여 _strike_ 와 _ball_ 카운트
    - _HashMap\<String, Integer>_ 에 _strike_ 와 _ball_ 결과를 담아 반환
      <br/><br/>

### 4. _Validate Methods_

- <code>**validateGameInput**</code>
    - user의 입력이 _서로 다른 3자리 숫자_ 인지 검사
    - user의 입력이 잘못되었을 시 `IllegalArgumentException` 발생 후 어플리케이션 종료
      <br/><br/>

- <code>**validateRestartInput**</code>
    - user의 입력이 _1 또는 2_ 인지 검사
    - user의 입력이 잘못되었을 시 `IllegalArgumentException` 발생 후 어플리케이션 종료
      <br/><br/>

### 5. _Print Methods_

- <code>**printStartStmt**</code>
    - 게임 시작 안내문 출력
      <br/><br/>

- <code>**printInputStmt**</code>
    - 숫자 입력 안내문 출력
      <br/><br/>

- <code>**printResult**</code>
    - 볼, 스트라이크, 낫싱 결과 출력
      <br/><br/>

- <code>**printGameEndStmt**</code>
    - 정답 안내문 출력
      <br/><br/>

- <code>**printAskRestartStmt**</code>
    - 게임 재시작 여부 안내문 출력
      <br/><br/>

   