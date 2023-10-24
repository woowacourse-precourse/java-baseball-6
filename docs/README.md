<h1>기능 목록</h1>

<h2>1. Computer:computer:</h2>

   • 생성한 랜덤 Number를 저장하기 위한 객체

<h2>2. MyNumber:hand:</h2>

   • 내가 입력한 숫자들의 정보들을 저장하는 객체(strike, ball 개수)

<h2>3. BaseBallGame:baseball:</h2>

   • 게임실행을 위한 객체

           🔹run() : 게임 실행하는 기능
           
           🔹gameStart() : 게임시작을 알리는 기능
           
           🔹playGame() : 한 게임을 진행하는 기능
           
           🔹quitGame() : 한 게임이 끝난 것을 알리는 기능
           
           🔹playButton() : 게임이 끝난 후 재시작 할 지 결정하는 기능
           
           🔹getMyNumberResult() : 숫자 입력 후 숫자에 대한 결과를 나타내는 기능
           
           🔹getStrikeCount() : 입력한 숫자의 Strike 개수를 세는 기능
           
           🔹getBallCount() : 입력한 숫자의 Ball 개수를 세는 기능
           
           🔹createRandomNumber() : 중복되지 않은 숫자 3자리를 발생시키는 기능

<h2>4. Validator:white_check_mark:</h2>
   
   • 입력한 값을 검증하는 객체

           🔹validateInputNumber() : 입력한 숫자를 검증하는 기능
           
           🔹validatePlayButton() : 입력한 버튼 값을 검증하는 기능
           
           🔹isDuplicateNumber() : 중복되는 숫자가 있는지 검증하는 기능
           
           🔹isNotCorrectRange() : 입력받은 숫자의 자릿수를 검증하는 기능
           
           🔹isNotIntegerType() : 입력받은 숫자가 정수형인지 검증하는 기능
           
           🔹isNotCorrectButton() : 재실행 버튼 값이 올바른지 검증하는 기능

<h2>5. InputView:page_with_curl:</h2>
    
   • 입력을 처리하는 입력 객체

           🔹inputNumber() : 숫자를 입력하는 기능
           
           🔹inputPlayButton() : 재시작 버튼을 입력하는 기능
           
           🔹splitStringToDigits() : 입력 받은 String형식 Number를 Integer형 List로 바꿔주는 기능

<h2>6. OutputView:outbox_tray:</h2>
    
   • 출력을 처리하는 객체

           🔹printStartMessage() : 게임 시작 메세지를 출력하는 기능
        
           
           🔹printEndMessage() : 게임 종료 메세지를 출력하는 기능
           
           🔹printMyNumberResult() : 게임 결과를 출력하는 기능

-------------------------------------------------------------------
<h1>전체 로직</h1>

<h3>1. 숫자 야구 시작 메세지 출력</h3>

<h3>2. 숫자 야구 정답 랜덤으로 생성</h3>
   
<h3>3. 맞출 때까지 반복(1~6) :</h3>

        1. result(ball, strike) 초기화
        2. 숫자를 입력 메세지 출력
        3. 숫자 입력받기
   
           - 입력 받을 때 숫자 예외처리
        
        4. 입력받은 숫자 strike와 ball에 저장
        5. 결과 계산
        6. 결과 출력
<h3>4. 3strike라면 종료, 못 맞췄다면 반복</h3>
        
<h3>5. 종료 메세지(+재시작 메세지) 출력</h3>
<h3>6. 재시작 number 입력</h3>

-------------------------------------------------------------------

