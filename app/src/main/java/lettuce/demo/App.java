/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lettuce.demo;

public class App {

    public static void main(String[] args) throws InterruptedException {
        LettuceService service = new LettuceService();
        for (int i = 0; i < 1000; i++) {
            service.doEet();
            Thread.sleep(500);
            System.out.print(i + " ");
        }
    }
}
