package sungs.msa.apps.msapp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

/////////////////////////////////////////////////////////////////////////////////////////////
//WebClient를 SCL(spring cloud loadBalancer)과 연계하여 다른 앱을 호출하는 컨트롤러 테스트
// ex) ms-app1 --> ms-app2 
/////////////////////////////////////////////////////////////////////////////////////////////

@RestController
public class WebClientLoadbalancerController {
    private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    private WebClient webClient;
    
    
    
    
    @GetMapping("/testscl1")    
    public Mono<String> testSCL1() {
    	
    	log.info("====== /testscl1 in ==========");
		
		
    	Mono<String> response = webClient.get()
                .uri("/webclient/test SCL1")
                .retrieve()
                .bodyToMono(String.class);
    	

        log.info("====== /testscl1 out ==========");
        
        return response;
        
        
    }    
}