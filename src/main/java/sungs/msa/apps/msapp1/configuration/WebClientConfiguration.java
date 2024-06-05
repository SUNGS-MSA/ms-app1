package sungs.msa.apps.msapp1.configuration;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
	
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    //loadbalance를 이용해서 호출하겠다는 정책
    WebClientConfiguration(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.lbFunction = lbFunction;
    }
    
    @Bean //Tracing(micrometer+zipkin) 할려면 webClient는 반드시 빈으로 등록해야하고, 빈 함수는 반드시 WebClient.Builder 를 인수로 받는 빈이어야 한다.)
    public WebClient webClient(WebClient.Builder builder) {
      return builder
    		  .filter(this.lbFunction)
              .baseUrl("http://ms-app2")
    		  .build();
    		  
    }
	/*
    @Bean 
    public WebClient webClient() {
    	 
 
    	WebClient client = WebClient.builder()
                .filter(this.lbFunction)
                .baseUrl("http://ms-app2")  // 'ms-app2' 은 호출할 어플리케이션 명이다. Eureka 이용
                .build();
    	
    	return client;
    	
    }
    */
}
