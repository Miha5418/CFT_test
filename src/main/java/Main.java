import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author karpeykin
 * @Date 26.02.2021
 */
public class Main {
    public static void main(String[] args) {

        List<String> listInFile = new ArrayList<>();
        String sortingMode = "a";
        String dataType = null;
        String outFile = null;

        try {
            if (args[0].equals("a") || args[0].equals("d")) {
                sortingMode = args[0];
                dataType = args[1];
                outFile = args[2];
                for (int i = 3; i < args.length; i++) {
                    listInFile.add(args[i]);
                }
            } else if (args[0].equals("s") || args[0].equals("i")) {
                dataType = args[0];
                outFile = args[1];
                for (int i = 2; i < args.length; i++) {
                    listInFile.add(args[i]);
                }
            } else {
                System.out.println("Указан не верный вид данных.");
                System.exit(0);
            }
        } catch (Throwable e) {
            System.out.println("Вы указали не верные аргументы для запуска. Пожалуйста, сверьтесь с требования и запустите заного.");
            System.exit(5);
        }

        List<?> ListResult = Work.getGeneralList(dataType, listInFile, sortingMode);

        Work.writeInFile(outFile, ListResult);

        System.out.println("Слияние файлов прошло успешно.");


    }
}
