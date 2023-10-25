# 구현할 기능

## 게임 Flow

### 정답 생성

- 랜덤으로 1~9사이의 숫자 생성
- 중복된 숫자가 있으면 안되니 중복 체크

### 플레이어 숫자 생성 및 입력

- camp.nextstep.edu.missionutils.Console의 readLine()을 통한 입력
- 입력이 1~9사이의 숫자인지 확인, 잘못된 값이라면 IllegalArgumentException 후 종료

### 게임 결과

- 숫자가 존재하고 자리까지 맞는 갯수를 n스트라이크
- 숫자는 존재하나 자리는 틀리다면 n볼
- 숫자 3개모두 없다면 '낫싱'을 출력한다.

### 게임 반복

- 사용자가 게임을 다시시작 하기 위해 1을 입력하거나 완전히 종료하기 위해 0을 입력한다.

## 기능

### Controller

- GameContoller : 게임의 전체적인 실행

### domain

- Computer : 컴퓨터의 정답의 설정
- Player : 플레이어의 숫자 설정 담당

### service

- CompareAnswerWithPlayerNumber : 플레이어와 AnswerCreator의 숫자를 비교, 비교 후 strike,ball의 수 저장

### view

- InputView : 플레이어에게 입력하라는 안내와 입력을 담당
- ResultView : CompareAnswerWIthPlayerNumber의 결과를 가져와 출력
- RegameView : 게임의 재시작, 종료에 대한 출력을 담당

### util

- AnswerCreator: AnswerCreator에 넣어줄 정답을 생성 