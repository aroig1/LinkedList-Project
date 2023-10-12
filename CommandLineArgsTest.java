public class CommandLineArgsTest {
    public static void main(String[] args) {
        System.out.println("Below are the command line arguments");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}