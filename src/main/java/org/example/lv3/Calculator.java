package org.example.lv3;

public class Calculator <T extends Number>{
    private T x,y;

    public void setX(T x){
        this.x = x;
    }

    public void setY(T y){
        this.y = y;
    }

    public T getX(){
        return x;
    }

    public T getY(){
        return y;
    }

    //getter 구현

    //setter 구현
}
