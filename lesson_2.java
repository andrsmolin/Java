import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class lesson_2 {
    public static void main(String[] args) throws IOException {
        sql();
        Scanner iScanner = new Scanner(System.in);
        calculationLog(iScanner);
        iScanner.close();
    }

    // Дана строка sql-запроса "select * from students where ".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    // Данные для фильтрации приведены ниже в виде json строки.
    // Если значение null, то параметр не должен попадать в запрос.
    // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
    // "city":"Moscow", "age":"null"}

    private static void sql() {
        HashMap<String, String> map_dect = new HashMap<>();
        map_dect.put("name", "Ivanov");
        map_dect.put("country", "Russia");
        map_dect.put("city", "Moscow");
        map_dect.put("age", null);

        // System.out.println(map_dect);
        // System.out.println(map_dect.entrySet());
        // System.out.println(map_dect.keySet());
        // System.out.println(map_dect.values());

        ArrayList<String> kes_map_dect = new ArrayList<>(map_dect.keySet());
        ArrayList<String> values_map_dect = new ArrayList<>(map_dect.values());

        StringBuilder zapros_str = new StringBuilder("select * from students where ");

        for (int i = 0; i < kes_map_dect.size(); i++) {
            if (values_map_dect.get(i) != null) {
                if (i > 0) {
                    zapros_str.append(" and ");
                }
                zapros_str.append(kes_map_dect.get(i) + " = " + values_map_dect.get(i));
            }
        }
        System.out.println(zapros_str);
    }

    // 4*. К калькулятору из предыдущего дз добавить логирование

    private static void calculationLog(Scanner s) throws IOException {
        System.out.println("\n КАЛЬКУЛЯТОР");
        FileWriter logCalc = new FileWriter("logCalc.txt", true);

        while (true) {
            System.out.println(
                    "\n1 - Сложение\n2 - Вычитание\n3 - Умножение\n4 - Деление\n5 - Возвести в степень\n6 - Выход");
            int choise = readInt(s, "Выберите действие: ");
            if (choise == 1 || choise == 2 || choise == 3 || choise == 4 || choise == 5) {
                int a, b = 0;
                a = readInt(s, "Первое число: ");
                b = readInt(s, "Второе число: ");
                if (choise == 1) {
                    String operation1 = new String(
                            Integer.toString(a) + " + " + Integer.toString(b) + " = " + Integer.toString(a + b));
                    System.out.println(operation1);
                    logCalc.append(operation1 + "\n");
                } else if (choise == 2) {
                    String operation2 = new String(
                            Integer.toString(a) + " - " + Integer.toString(b) + " = " + Integer.toString(a - b));
                    System.out.println(operation2);
                    logCalc.append(operation2 + "\n");
                } else if (choise == 3) {
                    String operation3 = new String(
                            Integer.toString(a) + " * " + Integer.toString(b) + " = " + Integer.toString(a * b));
                    System.out.println(operation3);
                    logCalc.append(operation3 + "\n");
                } else if (choise == 4) {
                    String operation4 = new String(
                            Integer.toString(a) + " / " + Integer.toString(b) + " = " + Integer.toString(a / b));
                    System.out.println(operation4);
                    logCalc.append(operation4 + "\n");
                } else {
                    String operation5 = new String(
                            Integer.toString(a) + " ^ " + Integer.toString(b) + " = " + Math.pow(a, b));
                    System.out.println(operation5);
                    logCalc.append(operation5 + "\n");
                }
            } else if (choise == 6) {
                break;
            } else {
                System.out.println("Неверный ввод!");
            }

        }
        logCalc.close();
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
}
