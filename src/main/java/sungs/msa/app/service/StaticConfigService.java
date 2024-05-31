package sungs.msa.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author spring
*/

@Service
public class StaticConfigService {
	//appication 공용 properties
	@Value("${taeng.profile}")
	private String profile;
	
	@Value("${taeng.comment}")
	private String comment;
	
	
	@Value("${configmng.id}")
	private String configmng_id;
	
	
	
	
	
	//개별앱 properties
	@Value("${ms-app1.comment}")
	private String ms_app1_comment;
	
	
	
	public Map<String, String> getConfig(){
		Map<String, String> map = new HashMap<>();
		map.put("profile", profile);
		map.put("comment", comment);
		map.put("configmng_id", configmng_id);
		map.put("ms_app1_comment", ms_app1_comment);
		return map;
	}
}