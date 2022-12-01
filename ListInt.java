import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;


public class ListInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите минимум: ");
        int min = input.nextInt();
        System.out.println("Введите максимум: ");
        int max = input.nextInt();
        System.out.println("Введите рамер массива: ");
        int s = input.nextInt();
        input.close();
        System.out.println();

        List<Integer> arr = getRandomArrayList(s, min, max);
        System.out.println(arr);
        getSortDeleteChet(arr);
        System.out.println(arr);
    }

    static int getRandomNumberInt(int minimum, int maximum) {
        Random random = new Random();
        return random.nextInt(minimum, maximum);
    }

    static List<Integer> getRandomArrayList(int size, int minimum, int maximum) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            array.add(getRandomNumberInt(minimum, maximum));
        }
        return array;
    }

    static List<Integer> getSortDeleteChet(List<Integer> array) {
        for (int j = 0; j < array.size(); j++) {
            if (array.get(j) % 2 == 0) {
                array.remove(j);
                j--; 
            }
        }
        return array;
    }
}