package sungs.msa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sungs.msa.app.service.DynamicConfigService;
import sungs.msa.app.service.StaticConfigService;

/**
 * @author spring
*/

@RestController
public class ConfigController {
	
	private final StaticConfigService configStaticService;
	private final DynamicConfigService configDynamicService;
	
	@Autowired 	// 단일 생성자여서 어노테이션을 제외해도 되긴하다.
	public ConfigController(StaticConfigService configStaticService, DynamicConfigService configDynamicService) {
		this.configStaticService = configStaticService;
		this.configDynamicService = configDynamicService;
	}
	
	@GetMapping(value="/static")
	public Object getConfigFromStatic() {
		return configStaticService.getConfig();
	}
	
	@GetMapping(value="/dynamic")
	public Object getConfigFromDynamic() {
		return configDynamicService.getConfig();
	}
}