import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<MyCallable> list = new ArrayList<>();

        list.add(new MyCallable("1"));
        list.add(new MyCallable("2"));
        list.add(new MyCallable("3"));
        list.add(new MyCallable("3"));

        try {
            pool.invokeAll(list);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            Integer result = pool.invokeAny(list);
            System.out.println("Количество отправленных сообщений " + result);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        pool.shutdown();
    }
}
