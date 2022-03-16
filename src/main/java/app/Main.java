package app;

import javax.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

public class Main {
  private static final Logger log = Logger.getLogger(Main.class);

  public static void main(String... args) throws Exception {
    SeContainerInitializer.newInstance().initialize();
  }

  @Incoming("my-topic")
  public void consume(String message) throws Exception {
      log.info("Message received: " + message);
      throw new Exception("sending to DLQ");
  }
}
