# 🚀 설계 필요 목록
### 필요 변수 목록
- int inputNumber (사용자 입력 숫자) 
- int inputFirstNum(사용자 입력 수 중 100의 자리 수)
- int inputSecondNum(사용자 입력 수 중 10의 자리 수)
- int inputThirdNum(사용자 입력 수 중 1의 자리 수)
- int randomNumber (랜덤하게 추출된 세자리 숫자)
- int randomFirstNumber (100의 자리로 인식할 랜덤한 숫자)
- int randomSecondNumber (10의 자리로 인식할 랜덤한 숫자)
- int randomThirdNumber (1의 자리로 인식할 랜덤한 숫자)
- int strike, ball (스트라이크, 볼 횟수)
------------------------------------
### 설계 이유
- ball, strike 판단 위해서 루프 반복이 잦음
   + 랜덤한 값 추출 시 동일 숫자 존재 여부 판단
   + 사용자 숫자 입력 시 동일 숫자 존재 여부 판단
   + strike, ball 판단 위한 루프
- 입력, 추출한 3자리 숫자 분리할 필요성 높다고 판단 
- ---------------------------------------
### 게임 로직 구현 

1. 랜덤한 숫자 추출 (Randoms API 활용)
   + 동일 숫자 존재 시 (1.로 회귀)
2. 사용자로부터 inputNumber 입력
3. randomNumber와 inputNumber의 100, 10, 1의 자리 값 비교 루프
   + randomNumber 100의 자리와 inPutNumber 100, 10, 1의 자리 비교
     +  같은 자리 숫자끼리 동일 시 strike+1 및 루프 종료
     +  다른 자리 숫자와 동일 시 ball+1 및 루프 종료
   + randomNumber 10의 자리와 inPutNumber 100, 10, 1의 자리 비교
       +  같은 자리 숫자끼리 동일 시 strike+1 및 루프 종료
       +  다른 자리 숫자와 동일 시 ball+1 및 루프 종료
   + randomNumber 1의 자리와 inPutNumber 100, 10, 1의 자리 비교
      +  같은 자리 숫자끼리 동일 시 strike+1 및 루프 종료
      +  다른 자리 숫자와 동일 시 ball+1 및 루프 종료
5. strike, ball 횟수에 따른 문구 출력
    + 3strike시 게임 종료 및 재시작 요청 문구 출력
        + 1 입력 시 게임 재시작(1.로 회귀)
        + 2 입력 시 게임 종료
    + strike, ball 없을 시 
        + '낫싱' 문구 출력 후 (2.로 회귀)
    + 나머지 경우
        + strike, ball 횟수 출력 후 (2.로 회귀)

### 예외처리(try, catch 문 활용) - IllegalArgumentException 발생
1. inputNumber에 '3자리', '숫자'가 입력되었는가
2. 사용자 입력 구문에 1,2외의 다른 문구가 들어갔는가?
2. 