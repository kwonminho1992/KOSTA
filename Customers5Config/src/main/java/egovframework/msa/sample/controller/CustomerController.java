package egovframework.msa.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RefreshScope // config server의 설정이 바뀌면 바뀐 내용을 반영한다는 의미의 annotation
public class CustomerController {
  @Value("${server.port}") // @value : 설정파일의 property 값을 가져오는 annotation
  private String port;

  @Value("${config.profile}")
  private String profile;

  @Value("${config.message}")
  private String message;

  @GetMapping("/{customerId}")
  public String getCustomerDetail(@PathVariable String customerId) {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("#" + port + " : request customerId :" + customerId);
    return "[#" + port + " Customer id = " + customerId + " at " + System.currentTimeMillis()
        + ", profile=" + profile + ", message=" + message + "]";
  }
}
