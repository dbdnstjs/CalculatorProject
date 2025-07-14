package org.example.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv3Calculator {
    public static void main(String[] args) {
        boolean chk;
        double x, y, result;
        String z;

        Calculator<Double> cal = new Calculator<>(); // Calculator 객체 생성, 제네릭 타입 명시
        Scanner sc = new Scanner(System.in); // Scanner 자원 생성

        while (true) {
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

                    if (op == null) {
                        System.out.println("오류: 올바르지 않은 연산자 기호입니다.");
                        sc.nextLine(); // 버퍼 정리
                        break;
                    }

                    result = 0;
                    switch (op.getOp()) {
                        case "+":
                            result = x + y;
                            break;
                        case "-":
                            result = x - y;
                            break;
                        case "*":
                            result = x * y;
                            break;
                        case "/":
                            if (y == 0) {
                                System.out.println("오류: 0으로 나눌 수 없습니다.");
                                break;
                            } else result = x / y;

                        case "%":
                            if (y == 0) {
                                System.out.println("오류: 0으로 나눌 수 없습니다.");
                                break;
                            } else result = x % y;
                    }
                    System.out.println(cal.getX() + " " + op.getOp() + " " + cal.getY() + " = " + result);

                    chk = true;
                    while (chk) {
                        System.out.println("현재 저장된 결과를 저장하겠습니까? (Y/N)");
                        String is_print = sc.next();
                        if (is_print.equals("Y") || is_print.equals("y")) {
                            chk = false;
                            cal.addresults(result);
                            System.out.println("저장된 결과: " + cal.getResults());
                        } else if (is_print.equals("N") || is_print.equals("n")) {
                            chk = false;
                        } else {
                            System.out.println("오류 : Y 또는 N 중 하나를 입력하세요.");
                        }
                    }

                    chk = true;
                    while (chk) {
                        System.out.println("가장 오래된 결과를 삭제하겠습니까? (Y/N)");
                        String is_del = sc.next();
                        if (is_del.equals("Y") || is_del.equals("y")) {
                            if (cal.removeResult()) {
                                System.out.println("삭제 완료.");
                                System.out.println("현재 저장된 결과: " + cal.getResults());
                            } else {
                                chk = false;
                                System.out.println("삭제할 결과가 없습니다.");
                            }
                        } else if (is_del.equals("N") || is_del.equals("n")) {
                            chk = false;
                        } else {
                            System.out.println("오류 : Y 또는 N 중 하나를 입력하세요.");
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("오류: 지원하지 않는 연산자입니다.");
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("오류: 숫자가 아닌 값을 입력했습니다.");
                sc.nextLine();
            } catch (Exception e) {  //기타 오류
                System.out.println("오류: " + e.getMessage());
                sc.nextLine();
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String is_exit = sc.next();
            if (is_exit.equals("exit")) break;
            sc.nextLine(); //버퍼 비우기
        }
        sc.close();// Scanner 자원 해제

        //스트림 + 람다로 조회조건 추가 (큰순 출력, 작은순 출력, 원하는 값 조회, 원하는 범위 값 출력)

        //깃

    }
}