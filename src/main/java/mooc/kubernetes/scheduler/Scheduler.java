package mooc.kubernetes.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

@Component
public class Scheduler {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final Random random = new Random();

    private static String lastStatus;
    private static LocalDateTime lastTimestamp;

    @Scheduled(fixedRate = 5000)
    public void startRandomStringGeneration() {
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

            lastTimestamp = LocalDateTime.now();
            lastStatus = str;
        System.out.println(lastTimestamp + " " +  lastStatus);
    }

    public static void stopGeneration() {
        scheduler.shutdown();
    }

    public static String getStatus() {
        return lastTimestamp + ": " + lastStatus;
    }
}
