import java.util.Scanner;

public class lesson_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        triangleDidgit(readInt(iScanner, "Введите индекс для расчета треугольного числа: "));
        factorial(readInt(iScanner, "Введите число для расчета факториала: "));
        simpleDidgits();
        calcChoise(iScanner);
        iScanner.close();
    }

    private static int readInt(Scanner s, String text) { // Проверка ввода числа
        while (true) {
            System.out.print(text);
            String line = s.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.err.println("Error: wrong integer");
            }
        }
    }

    private static void triangleDidgit(int numb) { // Вычисляем сумму чисел до введенного
        System.out.println("Треугольное число от " + numb + " = " + numb * (numb + 1) / 2);
    }

    private static void factorial(int numb) { // Вычисляем факториал
        int res = 1;
        for (int i = 1; i <= numb; i++) {
            res *= i;
        }
        System.out.println(numb + "! = " + res);
    }

    private static void simpleDidgits() { // Вывод простых чисел
        for (int i = 1; i <= 1000; i++) {
            int count = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count += 1;
                    break;
                }
            }
            if (count == 0) {
                System.out.print(i + "; ");
            }
        }
    }

    private static void calcChoise(Scanner s) { // Калькулятор (выбор функции)
        System.out.println("\nКАЛЬКУЛЯТОР");
        while (true) {
            System.out.println(
                    "1 - Сложение\n2 - Вычитание\n3 - Умножение\n4 - Деление\n5 - Возвести в степень\n6 - Выход");
            int choise = 0;
            choise = readInt(s, "Выберите действие: ");
            if (choise == 1) {
                calcSumm(s);
            }
            if (choise == 2) {
                calcSubtr(s);
            }
            if (choise == 3) {
                calcMult(s);
            }
            if (choise == 4) {
                calcDivision(s);
            }
            if (choise == 5) {
                calcPow(s);
            }
            if (choise == 6) {
                break;
            }
            if (choise < 1 && choise > 6) {
                System.out.println("Неверный ввод!");
            }
        }
    }

    private static void calcSumm(Scanner s) { // Калькулятор сложение
        int a, b = 0;
        System.out.println("СЛОЖЕНИЕ");
        a = readInt(s, "Первое слагаемое: ");
        b = readInt(s, "Второе слагаемое: ");
        System.out.printf("%d + %d = %d \n", a, b, a + b);
    }

    private static void calcSubtr(Scanner s) { // Калькулятор вычитание
        int a, b = 0;
        System.out.println("ВЫЧИТАНИЕ");
        a = readInt(s, "Уменьшаемое: ");
        b = readInt(s, "Вычитаемое: ");
        System.out.printf("%d - %d = %d \n", a, b, a - b);
    }

    private static void calcMult(Scanner s) { // Калькулятор умножение
        int a, b = 0;
        System.out.println("УМНОЖЕНИЕ");
        a = readInt(s, "Первый множитель: ");
        b = readInt(s, "Второй множитель: ");
        System.out.printf("%d x %d = %d \n", a, b, a * b);
    }

    private static void calcDivision(Scanner s) { // Калькулятор деление
        int a, b = 0;
        System.out.println("ДЕЛЕНИЕ");
        a = readInt(s, "Делимое: ");
        b = readInt(s, "Делитель: ");
        System.out.printf("%d / %d = %d \n", a, b, a / b);
    }

    private static void calcPow(Scanner s) { // Калькулятор возведение в степень
        int a, b = 0;
        System.out.println("ВОЗВЕДЕНИЕ В СТЕПЕНЬ");
        a = readInt(s, "Аргумент: ");
        b = readInt(s, "Степень: ");
        System.out.println(a + " ^ " + b + " = " + Math.pow(a, b));
    }
}
