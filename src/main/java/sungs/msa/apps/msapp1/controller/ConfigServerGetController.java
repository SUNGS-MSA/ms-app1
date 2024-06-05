package sungs.msa.apps.msapp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sungs.msa.apps.msapp1.service.DynamicConfigService;
import sungs.msa.apps.msapp1.service.StaticConfigService;

/**
 * @author spring
*/
/////////////////////////////////////////////////////////////////////////////////////////////
// ConfigServer로 부터 설정값을 읽어와서 출력하는 테스트  /static 과 /dynamic  @RefreshScope 어노테이션 사용여부이다.
//  - @RefreshScope 은 config server 변경내용을 app재시작없이 동적적용한다.
/////////////////////////////////////////////////////////////////////////////////////////////
@Slf4j
@RestController
public class ConfigServerGetController {
	
	private final StaticConfigService configStaticService;
	private final DynamicConfigService configDynamicService;
	
	@Autowired 	// 단일 생성자여서 어노테이션을 제외해도 되긴하다.
	public ConfigServerGetController(StaticConfigService configStaticService, DynamicConfigService configDynamicService) {
		this.configStaticService = configStaticService;
		this.configDynamicService = configDynamicService;
	}
	
	@GetMapping(value="/static")
	public Object getConfigFromStatic() {
		return configStaticService.getConfig();
	}
	
	@GetMapping(value="/dynamic")
	public Object getConfigFromDynamic() {
		log.info("====== /dynamic in ==========");
		
		log.info("====== /dynamic out ==========");
		
		return configDynamicService.getConfig();
	}
}