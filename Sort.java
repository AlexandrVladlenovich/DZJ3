import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите минимум: ");
        int min = input.nextInt();
        System.out.println("Введите максимум: ");
        int max = input.nextInt();
        System.out.println("Введите размер массива");
        int s = input.nextInt();
        input.close();

        List<Integer> arr = getRandomArrayList(s, min, max);
        System.out.println(arr);
        getSortMerge(arr, 0, arr.size()-1);
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

    static void getSortMerge(List<Integer> array, int indexStart, int indexEnd) {
        if (indexEnd <= indexStart) return;

        int mid = indexStart + (indexEnd - indexStart) / 2;
        getSortMerge(array, indexStart, mid);
        getSortMerge(array, mid + 1, indexEnd);

        List<Integer> tempArray = new ArrayList<Integer>(array.size());
        tempArray.addAll(array);
            
        int i = indexStart, j = mid + 1;
        for (int k = indexStart; k <= indexEnd; k++) {
            if (i > mid) {
                array.set(k, tempArray.get(j));
                j++;
            } else if (j > indexEnd) {
                array.set(k, tempArray.get(i));
                i++;
            } else if (tempArray.get(j) < tempArray.get(i)) {
                array.set(k, tempArray.get(j));
                j++;
            } else {
                array.set(k, tempArray.get(i));
                i++;
            }
        }
    }    
}