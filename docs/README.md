# 1주차 미션 : 숫자 야구 기능 목록 (객체가 어떻게 동작 할지에 대해 생각)
------------

## 1. Application의 main()

> + 게임을 시작하는 메서드를 호출<br/>
>+ 동작과정
   >
   >
1. GameStart() 메서드 호출
------------

## 2. GameStart()

> + 게임을 시작하고 playGame() 메서드 호출<br/>
>+ 동작과정
   >
1. "숫자 야구 게임을 시작합니다." 출력
>  2. playGame() 메서드 호출
------------

## 3. playGame()

> + 플레이어(사용자)의 숫자를 입력을 받고 playingGame() 메서드 호출<br/>
>+ 동작과정
   >
1. opponentNumbers 배열을 생성하는 checkForDuplicateDigitsInRandomNumber() 호출
>  2. playingGame() 메서드를 opponentNumbers를 매개변수로 호출
------------

## 3-1. checkForDuplicateDigitsInRandomNumber()

> + 상대방(컴퓨터)의 숫자를 한자리씩 무작위로 생성하여 3자리 숫자 생성<br/>
>+ 동작과정
   >
1. nonDuplicateDigitsArray 배열을 생성해서 3자리 숫자 중 1자리씩 1~9의 범위의 무작위 정수를 Randoms.pickNumberInRange 라이브러리를 사용해서 배열 안에 같은 숫자가
   없으면 추가하는 방식으로 중복되지 않은 3자리 숫자 배열 생성
>   2. nonDuplicateDigitsArray 반환
------------

## 4. playingGame()

> + InputPlayerNum() 메서드 호출 및 상대방의 숫자와 플레이어의 숫자로 countStrikesAndBalls() 메서드 호출<br/>
>+ 동작과정
   >
1. 플레이어(사용자)의 3자리 숫자 입력을 받는 InputPlayerNum() 메서드 호출
>  2. 매개변수로 받은 opponentNumbers와 playerNumbers를 countStrikesAndBalls() 메서드의 매개변수로 전달하여 호출
------------

## 5. InputPlayerNum()

> + 플레이어(사용자)의 숫자를 입력으로 받고,checkPlayerNumber에() 메서드 호출<br/>
>+ 동작과정
   >
1. "숫자를 입력해 주세요." 출력
>   2. Console.readLine();으로 사용자의 입력을 받아서 InputNum에 저장
>   3. checkPlayerNumber에 InputNum를 매개변수로 전달하며 호출
------------

## 5-1. checkPlayerNumber()

> + 3단계로 플레이어의 숫자를 검사하고 통과하지 못하면 IllegalArgumentException() 처리<br/>
>+ 동작과정
   >
1. checkPlayerNumberLength 메서드 호출 false이면 IllegalArgumentException() 예외 처리하고 프로그램 종료
>  2. checkPlayerNumberIsNumber 메서드 호출 false이면 IllegalArgumentException() 예외 처리하고 프로그램 종료
>  3. checkPlayerNumberDulplicate 메서드 호출 false이면 IllegalArgumentException() 예외 처리하고 프로그램 종료
>  4. 통과하면 stringToList() 메서드 호출
------------

## 5-1-1. checkPlayerNumberLength()

> + 입력받은 사용자의 숫자가 3자리인지 확인하는 메서드<br/>
>+ 동작과정
   >
1. boolean flag = false로 초기화
>  2. .length()를 사용하여 길이가 3이면 flag를 true로 초기화
>  3. flag 반환
------------

## 5-1-2. checkPlayerNumberIsNumber()

> + 입력받은 사용자의 숫자가 숫자로만 구성되어 있는지 확인하는 메서드<br/>
>+ 동작과정
   >
1. boolean flag = false로 초기화
>  2. try 구문에서 parseInt로 정수로 변경
>  3. catch 구문에서 NumberFormatException 에러 예외 처리를 flag를 반환으로 처리
>  4. flag를 true로 초기화
>  5. flag 반환

## 5-1-3. checkPlayerNumberDulplicate()

> + findDuplicates의 flag를 확인하여 true이면 flag를 반환하는 메서드<br/>
>+ 동작과정
   >
1. findDuplicates 메서드 호출
>  2. flag를 true로 초기화
>  3. findFlag가 true이면 flag를 true로 초기화
>  4. flag 반환

------------

## 5-1-3-1. findDuplicates()

> + 입력받은 사용자의 숫자 중 중복된 숫자가 있는지 확인하는 메서드<br/>
>+ 동작과정
   >
1. boolean flag = true로 초기화
>  2. uniqueDigits라는 HashSet 생성
>  3. playerNum를 반복문을 순회하며 문자열의 각 문자를 uniqueDigits에 없으면 추가
>  4. uniqueDigits 배열의 크기가 3이 아니면(중복된 숫자가 있으면) flag를 false로 초기화
>  5. flag 반환
------------

## 5. stringToList()

> + 플레이어의 숫자를 문자열에서 리스트로 바꾸는 메서드<br/>
>+ 동작과정
   >
1. 반복문을 순회하면서 각 자리의 문자를 정수로 형변환하여 Nums에 추가
>  2. Nums 배열 반환
------------

## 6. countStrikesAndBalls()

> + 플레이어와 상대방의 숫자를 대조하여 같은 위치, 같은 숫자이면 스트라이크, 다른 위치에 숫자가 포함되어 있으면 볼을 기준으로 스트라이크의 개수와 볼의 개수 파악하는 메서드<br/>
>+ 동작과정
   >
1. strikeCount, ballCount 라는 각각 스트라이크와 볼의 수를 저장하는 변수 선언
>  2. 반복문을 순회하면서 스트라이크와 볼의 개수 파악
>  3. strikeCount, ballCount를 담은 정수 compareList 배열 생성
>  4. displayGameResult() 메서드에 compareList를 매개변수로 호출
------------

## 7. displayGameResult()

> + 파악한 스트라이크와 볼의 개수를 정해진 형식으로 출력하는 메서드<br/>
>+ 동작과정
   >
1. 볼과 스트라이크가 0 초과이면 gameResult = ballScore + "볼 " + strikeScore + "스트라이크";
>  2. 볼은 0초과, 스트라이크가 0이면 gameResult = ballScore + "볼";
>  3. 볼은 0, 스트라이크가 0 초과 이면 gameResult = strikeScore + "스트라이크";
>  4. 볼과 스트라이크 모두 0이면 gameResult = "낫싱";
>  5. gameResult 출력
>  6. endGame 메서드에 gameResult와 opponentNumbers를 매개변수로 전달하며 호출
------------

## 8. endGame()

> + 스트라이크 개수가 3이면 selectGame() 메서드 호출하고 3이 아니면 playingGame() 메서드 재귀 호출<br/>
>+ 동작과정
   >
1. 스트라이크 개수가 3이면
>  2. "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
>  3. selectGame() 메서드 호출
>  4. 스트라이크 개수가 3이 아니면
>  5. playingGame() 메서드를 opponentNumbers를 매개변수로 호출
------------

## 9. selectGame()

> + 게임을 새로 시작할지 끝낼지 결정하는 메서드<br/>
>+ 동작과정
   >
1. "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
>  2. Console.readLine()로 사용자의 입력을 받아서 endingNum 변수 초기화
>  3. endingNum이 "1"이면 playGame() 메서드 재귀 호출
>  4. 2이면 프로그램 종료
  
