package org.example.lv3;

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
