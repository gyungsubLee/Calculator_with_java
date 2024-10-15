# 계산기 만들기



> ### 목차 
> - [요구사항](#요구사항-)
>- [버전 1 - if 문, switch 문](#버전-1)
>- [버전 2 - 클래스 분리. 추상 클래스](#버전-2)
>- [버전 3 - 인터페이스, 어댑터 패턴 적용](#버전-3)

<br/>

### 요구사항
- 콘솔 기반
-  사칙연산 ( `+`, `-`, `*`, `/` )
- 예외처리 - 나누기 `0` 지원 X

<br/>

## 버전 1

### 코드 예시 - if문

```java
public double calculate1(String operator, int a, int b) {
    double answer = 0;

    if (operator.equals("+")) {
        answer = a + b;
    } else if (operator.equals("-")) {
        answer = a - b;
    } else if (operator.equals("*")) {
        answer = a * b;
    } else if (operator.equals("/")) {
        if(b==0) throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
        answer = a / b;
    } else {
        throw new UnsupportedOperationException("지원되지 않는 연산자 입니다.");
    }
    return answer;
}
```

<br/>

### 코드 예시 - for 문

```java
public double calculate2(String operation, double a, double b) {
    switch (operation) {
        case "+": return a + b;
        case "-": return a - b;
        case "*": return a * b;
        case "/": {
            try{
                return a / b;
            } catch (ArithmeticException e){
                throw  new ArithmeticException("0으로 나눗셈 연산이 불가합니다.");
            }
        }
        default: throw new UnsupportedOperationException("지원되지 않는 연산자 입니다.");
    }
}

```

<br/>
<br/>


## 버전2  - 클래스 분리 및 추상 클래스 상속

### 클래스 다이어 그램
![스크린샷 2024-10-15 오후 9.36.54.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F95%2Ft8symb5521g2916cz4qtrsjc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_EnAi09%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-10-15%20%EC%98%A4%ED%9B%84%209.36.54.png)

<br/>


### 추상 클래스 - 추상 메서드 

```java
public abstract class AbstractOperation {
    public abstract double calculate(double a, double b);
}
```

<br/>

### 클래스 분리, <추상 클래스> 상속 및 <추상 메서드> 오버라이드 -> 다형성

```java
public class AddOperation extends AbstractOperation {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
```

. . .

```java
public class DivideOperation extends AbstractOperation {
    @Override
    public double calculate(double a, double b) {
        if(b==0) throw new ArithmeticException("0으로 나눗셈 연산 불가");
        return a / b;
    }
}
```

<br/>
<br/>

## 버전 3 - 인터페이스, 어댑터 패턴 적용

### 클래스 다이어 그램

![스크린샷 2024-10-15 오후 9.48.17.png](..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2F95%2Ft8symb5521g2916cz4qtrsjc0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_lAKqsb%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-10-15%20%EC%98%A4%ED%9B%84%209.48.17.png)

<br/>

### Interface

```java
public interface Operation {
    double calculate(double a, double b);
}
```

<br/>

### interface 구현 및 오버라이드 -> 다형성
```java
public class AddOperation implements Operation {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
```

. . .


```java
public class DivideOperation implements Operation {

    @Override
    public double calculate(double a, double b) {
        if(b==0) throw new ArithmeticException("0으로 나눗셈 연산 불가");
        return a / b;
    }
}
```

<br/>


### 어댑터 패턴 적용

- Map을 통해 어댑터 패턴 적용


```java
public class Calculator {
    private final Map<String, Operation> operationMappingAapter = new HashMap<>();

    public Calculator() {
        initOperationMappingMap();
    }

    private void initOperationMappingMap(){
        operationMappingAapter.put("+", new AddOperation());
        operationMappingAapter.put("-", new SubstractOperation());
        operationMappingAapter.put("*", new MultiplyOperation());
        operationMappingAapter.put("/", new DivideOperation());
    }

    public double calculate(String operator, double a, double b){
        Operation mappingOperation = operationMappingAapter.get(operator);
        if (mappingOperation == null) {
            throw new UnsupportedOperationException("Unknown operation: " + operator);
        }
        return mappingOperation.calculate(a, b);
    }
}
```
<br/>

### 



<br/>