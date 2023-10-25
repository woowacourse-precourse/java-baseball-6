# 미션 - 숫자 야구

## 기능 목록

### 1. 3자리의 랜덤 숫자 배정(상대방)
- 중복되지 않는 3자리 정수값 난수 생성
    * Randoms.pickNumberInRange()함수 사용
### 2. 3자리의 유저 숫자 입력 받기  
- 정답 예상 3자리 정수값 입력
    * 예외처리(6번)
### 3. 상대방과 유저의 숫자를 한 자리씩 비교하여 볼 카운트 계산
- 상대방 값과 유저값을 비교하여 
    * 존재하는 숫자, 자릿수 일치 : 스트라이크
    * 존재하는 숫자, 자릿수 불일치 : 볼
### 4. 답이 일치할 때까지 2~3과정 반복
### 5. 게임 재실행 여부 입력 1-재시작, 2-종료
### 6. 예외처리
- 유저 입력값
    - 정수값 외의 값 입력시
    - 3이외의 자릿수 입력시
    - 중복되는 숫자 입력시  
    - 자리수로 0 입력시

- 게임 재실행 여부
    - 1,2 이외 입력시



#### 실행 결과 예시
```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

#### 입력

- 세 자리 유저 정수값 입력
```
숫자를 입력해주세요 : 123
```

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
```