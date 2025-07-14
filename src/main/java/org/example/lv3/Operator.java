package org.example.lv3;

//연산기호 모음
public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%");

    private final String op;

    Operator(String op) {
        this.op = op;
    }

    public String getOp() {
        return op;
    }
}
