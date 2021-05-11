
import java.util.Scanner;

import static java.lang.System.out;

public class ConsoleUI {
    static Scanner sc = new Scanner(System.in);

    static String  greeting = "Hello, you are in the main menu!!!";

    static String main_menu = "Main menu:\n" +
                       "1. Show available cars\n" +
                       "2. Add car\n" +
                       "3. Remove car\n" +
                       "4. Show current clients\n" +
                       "5. Add client\n" +
                       "6. Remove client\n" +
                       "7. Form a deal\n" +
                       "8. Show all sales\n" +
                       "9. Show help\n" +
                       "0.Exit\n";
    //static final String common_prompt = "Enter "
    public static void start(String url)
    {
        out.println(greeting);

    }

    public static int getCommand()
    {
        out.println(main_menu);
        int cmd = Integer.parseInt(sc.nextLine());
        return cmd;
    }

    public static String getLineWith(String name)
    {
        out.println(name);
        return sc.nextLine();
    }

    static void printLine(String str)
    {
        out.println(str);
    }
}
