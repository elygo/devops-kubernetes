package mooc.kubernetes.scheduler;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Scheduler {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final Random random = new Random();

    public static void startRandomStringGeneration() {
        scheduler.scheduleAtFixedRate(() -> {
            String str = random.ints(48, 122)
                    .filter(i -> (i >= 48 && i <= 57) || (i >= 97 && i <= 122))
                    .limit(25)
                    .mapToObj(i -> String.valueOf((char) i))
                    .collect(Collectors.collectingAndThen(
                            Collectors.joining(""),
                            s -> {
                                // Add dashes every 5 characters
                                StringBuilder sb = new StringBuilder(s);
                                for (int i = 5; i < sb.length(); i += 6) {
                                    sb.insert(i, '-');
                                }
                                // Remove the trailing dash if it exists
                                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                return sb.toString();
                            }
                    ));

            System.out.println(LocalDateTime.now() + ": " + str);
        }, 0, 5, TimeUnit.SECONDS);
    }

    public static void stopGeneration() {
        scheduler.shutdown();
    }
}
