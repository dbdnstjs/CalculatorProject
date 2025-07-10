package org.example.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lv1Calculator {
    public static void main(String[] args) {
        boolean chk;
        char op = 0;
        char[] operators = {'+', '-', '*', '/', '%'};
        long x, y, result = 0;

        Scanner sc = new Scanner(System.in);
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

                switch (op) {
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = x - y;
                        break;
                    case '*':
                        result = x * y;
                        break;
                    case '/':
                        result = x / y;
                        break;
                    case '%':
                        result = x % y;
                        break;
                }

                System.out.println("결과: " + result);

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String ex = sc.next();
                if (ex.equals("exit")) break;
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
            sc.close();
        }
    }
}