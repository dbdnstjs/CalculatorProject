package org.example.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv3Calculator {
    public static void main(String[] args) {
        double x, y;
        String z;

        Calculator<Double> cal = new Calculator<>(); // Calculator 객체 생성, 제네릭 타입 명시
        Scanner sc = new Scanner(System.in); // Scanner 자원 생성

        try {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                x = sc.nextDouble();
                cal.setX(x);

                System.out.print("두 번째 숫자를 입력하세요: ");
                y = sc.nextDouble();
                cal.setY(y);

                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /, %) : ");
                z = sc.next();

                Operator op = null;
                for (Operator i : Operator.values()) {
                    if (i.getOp().equals(z)) {
                        op = i;
                        break;
                    }
                }

                if(op==null){
                    System.out.println("오류: 올바르지 않은 연산자 기호입니다.");
                    sc.nextLine(); // 버퍼 정리
                    break;
                }

                System.out.println("x :" + cal.getX());
                System.out.println("y :" + cal.getY());
                System.out.println("Z :" + op.getOp());

                sc.nextLine(); //버퍼 비우기
                break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("오류: 지원하지 않는 연산자입니다.");
        } catch (InputMismatchException e) {
            System.out.println("오류: 숫자가 아닌 값을 입력했습니다.");
            sc.nextLine();
        } catch (Exception e) {  //기타 오류
            System.out.println("오류: " + e.getMessage());
            sc.nextLine();
        } finally {
            sc.close();// Scanner 자원 해제
        }

        //합 출력

        //저장 여부

        //삭제 여부

        //스트림 + 람다로 조회조건 추가 (큰순 출력, 작은순 출력, 원하는 값 조회, 원하는 범위 값 출력)

        //깃

    }
}