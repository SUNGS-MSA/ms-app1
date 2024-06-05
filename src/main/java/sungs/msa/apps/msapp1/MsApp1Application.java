package sungs.msa.apps.msapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //유레카 클라이언트 적용
public class MsApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MsApp1Application.class, args);
	}

}
