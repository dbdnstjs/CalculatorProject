package org.example.lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {
    private T x, y;
    private List<T> results = new ArrayList<>(); // 연산 결과들을 저장할 리스트

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> setResults) {
        this.results = setResults;
    }

    public void addresults (T num){
        results.add(num);
    }

    // 오래된 결과 삭제
    public boolean removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            return true;
        }
        return false;
    }
}
