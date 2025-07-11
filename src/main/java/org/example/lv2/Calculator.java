package org.example.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Long> sum = new ArrayList<>(); // 연산 결과들을 저장할 리스트

    public long result(long num1, long num2, char op) {
        long num = 0;
        switch (op) {
            case '+':
                num = num1 + num2;
                break;
            case '-':
                num = num1 - num2;
                break;
            case '*':
                num = num1 * num2;
                break;
            case '/':
                num = num1 / num2;
                break;
            case '%':
                num = num1 % num2;
                break;
        }
        sum.add(num); //결과 리스트에 저장
        return num; // 결과 반환
    }

    // 오래된 결과 삭제
    public boolean removeResult() {
        if (!sum.isEmpty()) {
            sum.remove(0);
            return true;
        }
        return false;
    }

    //getter 구현
    public List<Long> getSum() {
        return sum;
    }

    //setter 구현
    public void setSum(List<Long> newSum) {
        this.sum = newSum;
    }
}