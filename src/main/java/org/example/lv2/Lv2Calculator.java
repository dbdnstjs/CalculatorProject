package org.example.lv2;

import java.util.Scanner;

public class Lv2Calculator {
    public static void main(String[] args) {
        long x, y, result = 0;
        char[] operators = {'+', '-', '*', '/', '%'};

        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                x = sc.nextLong();
                System.out.print("두 번째 숫자를 입력하세요: ");
                y = sc.nextLong();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char op = sc.next().charAt(0);

                System.out.println("결과: " + result);
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String chk = sc.next();
                if (chk.equals("exit")) break;
            }
        } catch (Exception e) {
            sc.nextLine();
        }

        sc.close();
    }
}