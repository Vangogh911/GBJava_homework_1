//Реализовать функцию возведения числа а в степень b. a, b ∈ Z.
//Сводя количество выполняемых действий к минимуму.
//Пример 1: а = 3, b = 2, ответ: 9
//Пример 2: а = 2, b = -2, ответ: 0.25
//Пример 3: а = 3, b = 0, ответ: 1
//Пример 4: а = 0, b = 0, ответ: не определено
//входные данные находятся в файле input.txt в виде
//b 3
//a 10
//Результат нужно сохранить в файле output.txt
//1000

import java.io.*;
import java.util.Objects;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String line;
        String[][] lines = new String[2][2];
        int a;
        int b;
        // Производим чтение данных из файла и разбиваем их на массив массивов для дальнейшего получения аргументов 'а' и 'b'
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            for (int i=0; i<2; i++){
                line = reader.readLine();
                if (line != null){
                    lines[i] = line.split(" ");
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        // Получаем аргументы 'а' и 'b', которые лежат в массиве парой (аргумент - значение)
        if(Objects.equals(lines[0][0], "a")){
            a = parseInt(lines[0][1]);
            b = parseInt(lines[1][1]);
        }
        else {
            a = parseInt(lines[1][1]);
            b = parseInt(lines[0][1]);
        }
        // Производим запись результата в файл
        try (BufferedWriter writter = new BufferedWriter(new FileWriter("output.txt"))) {
            if (a == 0){
                writter.write("Не определено");
            }
            else {
                writter.write(Double.toString(Math.pow(a, b)));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
