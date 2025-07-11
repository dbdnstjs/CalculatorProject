package org.example.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv2Calculator {
    public static void main(String[] args) {
        boolean chk;
        char op = 0;
        char[] operators = {'+', '-', '*', '/', '%'};
        long x, y;

        Calculator cal = new Calculator(); // Calculator 객체 생성
        Scanner sc = new Scanner(System.in); // Scanner 자원 생성
        try {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                x = sc.nextLong();

                chk = true;
                while (chk) {
                    System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /, %) : ");
                    op = sc.next().charAt(0);
                    for (char c : operators) {
                        if (c == op) {
                            chk = false;
                            break;
                        }
                    }
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                y = sc.nextLong();

                System.out.println("결과: " + cal.result(x, y, op));

                chk = true;
                while (chk) {
                    System.out.println("현재 저장된 결과를 저장하겠습니까? (Y/N)");
                    String is_print = sc.next();
                    if (is_print.equals("Y") || is_print.equals("y")) {
                        chk = false;
                        System.out.println("저장된 결과: " + cal.getSum());
                    } else if (is_print.equals("N") || is_print.equals("n")) {
                        chk = false;
                    }
                }

                chk = true;
                while (chk) {
                    System.out.println("가장 오래된 결과를 삭제하겠습니까? (Y/N)");
                    String is_del = sc.next();
                    if (is_del.equals("Y") || is_del.equals("y")) {
                        if (cal.removeResult()) {
                            System.out.println("삭제 완료.");
                            System.out.println("현재 저장된 결과: " + cal.getSum());
                        } else {
                            chk = false;
                            System.out.println("삭제할 결과가 없습니다.");
                        }
                    } else if (is_del.equals("N") || is_del.equals("n")) {
                        chk = false;
                    }
                }

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String is_exit = sc.next();
                if (is_exit.equals("exit")) break;

                sc.nextLine(); //버퍼 비우기
            }
        } catch (ArithmeticException e) {
            System.out.println("오류: 0으로 나눌 수 없습니다.");
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("오류: 숫자가 아닌 값을 입력했습니다.");
            sc.nextLine();
        } catch (Exception e) {  //기타 오류
            System.out.println("오류: " + e.getMessage());
            sc.nextLine();
        } finally {
            sc.close();// Scanner 자원 해제
        }
    }
}