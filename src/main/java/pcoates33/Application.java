package pcoates33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pcoates33.config.TestRefresh;


@SpringBootApplication(
    scanBasePackages = {"pcoates33"}
)
@EnableConfigurationProperties(value = {TestRefresh.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


}
