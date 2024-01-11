import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
  static public void log(String message) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String timestamp = dtf.format(LocalDateTime.now());
    System.out.printf("[%s] %s\n", timestamp, message);
  }
}
