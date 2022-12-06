import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class lesson_2_2 {
    public static void main(String[] args) throws IOException {
        vial();
    }
    // Реализуйте алгоритм сортировки пузырьком числового массива, результат после
    // каждой итерации запишите в лог-файл.

    private static void vial() throws IOException {
        FileWriter log = new FileWriter("logger.log", true);

        try {

            File file = new File("./iteration.txt");
            file.createNewFile();
            PrintStream stream = new PrintStream(file);
            System.setOut(stream);

            int[] mas = { 10, 15, 4, 3, 2 };

            boolean isSorted = false;
            int temp;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        isSorted = false;

                        temp = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = temp;
                        System.out.println("\n" + Arrays.toString(mas));
                    }
                }
            }
            stream.close();
        } catch (Exception e) {
            log.append("\n" + e.toString());
        }
        log.close();
    }
}
