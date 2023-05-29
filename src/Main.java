import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // b) Считываем 5 строк от пользователя и сохраняем их в список А
        List<String> listA = readStringsFromUser(5);

        // c) Отображаем список А
        System.out.println("Список А:");
        displayList(listA);

        // d) Считываем еще 5 строк от пользователя и сохраняем их в список Б
        List<String> listB = readStringsFromUser(5);

        // e) Объединяем списки А и Б в список С
        List<String> listC = combineLists(listA, listB);

        // f) Отображаем список С
        System.out.println("Список С после объединения:");
        displayList(listC);

        // g) Сортируем элементы списка С по длине слова
        sortListByLength(listC);

        // Выводим отсортированный список С
        System.out.println("Отсортированный список С:");
        displayList(listC);
    }

    // Метод для считывания строк от пользователя
    private static List<String> readStringsFromUser(int count) {
        List<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите " + count + " строк(и):");
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            strings.add(input);
        }
        return strings;
    }

    // Метод для отображения списка
    private static void displayList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
        System.out.println();
    }

    // Метод для объединения списков А и Б в список С
    private static List<String> combineLists(List<String> listA, List<String> listB) {
        List<String> combinedList = new ArrayList<>();

        int maxLength = Math.max(listA.size(), listB.size());
        for (int i = 0; i < maxLength; i++) {
            if (i < listA.size()) {
                combinedList.add(listA.get(i));
            }
            if (i < listB.size()) {
                combinedList.add(listB.get(listB.size() - 1 - i));
            }
        }

        return combinedList;
    }
    // Метод для сортировки списка по длине слова
    private static void sortListByLength(List<String> list) {
        Collections.sort(list, Comparator.comparingInt(String::length));
    }
}