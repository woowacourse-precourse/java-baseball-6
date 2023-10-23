#### 변수
1. restart : 초기값 1. 게임을 시작할지 안할지 정하는 변수. 1이면 재시작, 2이면 종료.
2. randomNumber[3] : 상대방 숫자 3가지 random추출
3. inputNumber[3] : 제시하는 숫자 3가지 
4. ball = 0 , strike = 0 : 볼과 스트라이크 개수 카운팅 

---
    
#### 알고리즘
1. print "숫자 야구 게임을 시작합니다."
2. restart == 1인 동안 반복문 실행
   1. strike != 3 동안 반복문 실행 
      1. ball = 0 , strike = 0
      2. print "숫자를 입력해주세요 : "
      3. inputNumber 세가지 입력받는 반복문 실행
      4. 결과 판독 실행 
         1. for randomNUmber i 
            2. for inputNumber j
               3. if inputNumber[j] == randomNumber[i]
                  4. if i==j strike +1
                  5. else ball +1
      5. if ball != 0 print "ball볼 "
      6. if strike !=0 print "strike스트라이크"
      7. if ball==0 strike==0 print 
   2. print "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
   3. print "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
   4. restart 입력받기