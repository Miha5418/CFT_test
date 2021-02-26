import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author karpeykin
 * @Date 26.02.2021
 */
public class Work {

    public static List<?> getGeneralList(String dataType, List<String> listInFile, String sortingMode) {
        List<?> listResult = null;


        if (dataType.equals("s")) {
            listResult = Work.readStringFromFile(sortingMode, listInFile);
        } else if (dataType.equals("i")) {
            listResult = Work.readIntegerFromFile(sortingMode, listInFile);
        }
        return listResult;

    }

    public static List<String> readStringFromFile(String sortingMode, List<String> list) {
        List<String> listString = new ArrayList<>();
        List<String> listStringSort;
        Scanner scanner = null;

        for (String fileName : list) {
            File file = new File(fileName);

            try {
                scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    listString.add(scanner.next());
                }

            } catch (FileNotFoundException e) {
                System.out.println("Файла " + fileName + " не найден.");
            }
        }
        scanner.close();
        return listStringSort = Work.sortString(sortingMode, listString);
    }

    public static List<Integer> readIntegerFromFile(String sortingMode, List<String> list) {
        List<Integer> listInteger = new ArrayList<>();
        List<Integer> listIntegerSort;

        Scanner scanner = null;


        for (String fileName : list) {
            int lineCount = 1;
            File file = new File(fileName);

            try {
                scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    try {
                        listInteger.add(Integer.parseInt(scanner.next()));
                    } catch (NumberFormatException e) {
                        System.out.println("Строка №" + lineCount + " в файле " + fileName + " окозалось символьным, оно не будет учитываться.");
                    }
                    lineCount++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("Файла " + fileName + " не найден.");
            }
        }
        scanner.close();
        return listIntegerSort = Work.sortInteger(sortingMode, listInteger);
    }

    public static List<String> sortString(String sortingMode, List<String> listString) {
        String[] array = new String[listString.size()];
        List<String> listStr = new ArrayList<>();

        for (int i = 0; i < listString.size(); i++)
            array[i] = listString.get(i);
        String tmp;
        int j;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            j = i - 1;
            while (j >= 0 && (sortingMode.equals("a") ? array[j].compareTo(tmp) > 0 : array[j].compareTo(tmp) < 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        Collections.addAll(listStr, array);
        return listStr;
    }

    public static List<Integer> sortInteger(String sortingMode, List<Integer> listInteger) {
        Integer[] array = new Integer[listInteger.size()];
        List<Integer> listInt = new ArrayList<>();

        for (int i = 0; i < listInteger.size(); i++)
            array[i] = listInteger.get(i);

        int tmp;
        int tmpTwo;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            tmpTwo = i - 1;
            while (tmpTwo >= 0 && (sortingMode.equals("a") ? array[tmpTwo] > tmp : array[tmpTwo] < tmp)) {
                array[tmpTwo + 1] = array[tmpTwo];
                tmpTwo--;
            }
            array[tmpTwo + 1] = tmp;
        }
        Collections.addAll(listInt, array);
        return listInt;

    }

    public static void writeInFile(String nameFile, List<?> list) {
        PrintWriter write = null;
        try {
            write = new PrintWriter(nameFile);
            for (Object el : list)
                write.println(el);
            write.close();
        } catch (FileNotFoundException e) {
            /*Как обработать исключение?*/
            System.out.println("Файл" + nameFile + "отсутствует");
        }


    }
}