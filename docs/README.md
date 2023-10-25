## 순서도

https://drive.google.com/file/d/1RY8nTepAhw1vHQE2sLiKxA1TvLNYWZ12/view?usp=sharing


![순서도](https://velog.velcdn.com/images/rednada1486_/post/7e780a0f-6078-45a8-a85e-4c3675b2d533/image.png)

<br><br><br><br>

## 구현할 기능 목록

<br>

1. 멤버변수 설정
```
- boolean playing : while문 반복 여부 설정 변수 
- int strike, ball, out : 스트라이크, 볼, 아웃 개수 카운팅하는 변수
- List<Integer> computer : 숫자야구 정답을 가지고 있는 함수
- List<Integer> user : 사용자가 입력한 답을 가지고 있는 함수
```

<br>

2. 숫자 야구 게임의 정답을 생성
```
- 메서드명 : createAnswer
- 입력 : 없음
- 출력 자료형 : 없음
- 출력예시 : {1, 2, 3} 
- 주의 사항 : 
    - 멤버변수 List<Integer> computer에 담을 예정
    - 1 ~ 9 까지 숫자만 뽑을 수 있음.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
    - 중복된 숫자가 없어야 함.
```

<br>

3. 사용자 입력 값 체크
```
- 메서드명 : validateUserInput
- 입력 자료형 : String
- 입력예시 : "123"
- 출력 자료형 : boolean
- 출력예시 : true, false
- 주의 사항 : 
    - 1. 세 글자 인지 체크
    - 2. 각 자리 문자가 
        - 2.1. 모두 숫자인지 학인
        - 2.2. 0이 아닌지 확인(1~9)
        - 2.3. 모두 통과하면 멤버변수 List<Ingeger> user에 add
    - 3. 중복 확인 
        - 멤버변수 List<Ingeger> user의 size 확인 
        - 3이랑 같으면 true 반환
        - 그 외에는 false 반환  
```

<br>

4. 종료 후 재시작 여부 물어보는 함수

```
- 메서드명 : qWhetherTerminate
- 입력 자료형 : String
- 입력 : 1 or 2 
- 출력 : true, false
- 주의사항 : 
    - 입력값이 올바르지 않으면 프로그램 종료 (Exceptin 발생) 
    - 1 입력 시 : true 반환
    - 2 입력 시 : false 반환
```


<br>

5. 유저가 입력한 답 중 숫자 하나에 대해서 ball, strike, out 판별
```
- 메서드명 : wheterBallStrikeOut
- 입력 자료형 : Integer
- 입력 예시 : 1
- 출력 자료형 : void
- 주의사항 : 
    - ball -> member 변수 ball + 1
    - strike -> member 변수 strike + 1
    - out -> member 변수 out + 1
    - 반복문 이용해서 자리 비교 O(n)
```

<br>

6. 결과 출력 기능
```
- 메서드명 : printResult
- 입력 : 없음
- 출력자료형 : void(콘솔에 출력)
- 출력 예시 : "1볼 1스트라이크"
- 주의사항 : 
    - String result = "" 에 추가한다.
    - out = 3 -> "낫싱"
    - b > 0 -> ball + "볼"
    - s > 0 -> strile + "스트라이크" 
```