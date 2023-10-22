# 📋 기능명세서

## Application

### 1. 앱 시작
- 시작 문구 출력

### 2. 게임 진행
- **while문** : 게임 종료하기 전까지
  - `Game` 객체 생성
  - 게임 진행 (**while문** : 숫자 맞출 때까지)
    - 숫자 입력
    - 숫자 입력값에 따른 출력
  - 게임 진행 여부 입력
  - 게임 진행 여부 받아오기

## Game

### 1. 랜덤값 지정
- **생성자**에서 지정
- 랜덤으로 서로 다른 3자리수 결정
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용

### 2. 숫자 입력
- 숫자 입력받기
  - `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
- 숫자 입력값 판단 → throw `IllegalArgumentException`
  - 길이가 3이 아님
  - 1~9 범위를 벗어나는 값이 있음
  - 같은 수 2번 이상 등장

### 3. 숫자 입력값에 맞게 출력
- 숫자 입력값 판단
  - 같은수 같은자리 → 스트라이크++
  - 같은수 다른자리 → 볼++
  - 다른수 → 낫싱
- 판단 결과에 따라 출력
- 숫자 맞추면 게임 종료 문구 출력

### 4. 게임 진행 여부 입력
- 게임 진행 여부 입력받기
- 게임 진행 여부 입력값 판단 → throw `IllegalArgumentException`
  - 1이나 2를 제외한 모든 입력값
- 2를 입력받으면 게임 끝났다고 표시