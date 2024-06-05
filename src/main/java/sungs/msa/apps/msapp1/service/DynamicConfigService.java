package sungs.msa.apps.msapp1.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author spring
*/

@Service
@RefreshScope  //config server 변경내용을 서버재시작없이 동적으로 받아 온다.
public class DynamicConfigService {
	
	//appication 공용 properties
		@Value("${taeng.profile}")
		private String profile;
		
		@Value("${taeng.comment}")
		private String comment;
		
		
		@Value("${configmng.id}")
		private String configmng_id;
		
		
		@Value("${spring.rabbitmq.host}")
		private String spring_rabbitmq_host;
		
		
		//개별앱 properties
		@Value("${ms-app1.comment:not configged}")  //@Value어노테이션에 ms-app1.comment 속성 값이 빈값이면 에러 나기때문에 빈값일경우 디폴트값 not configged 를 선언해 줬다..
		private String ms_app1_comment;
		
		
		
		public Map<String, String> getConfig(){
			Map<String, String> map = new HashMap<>();
			map.put("profile", profile);
			map.put("comment", comment);
			map.put("configmng_id", configmng_id);
			map.put("ms_app1_comment", ms_app1_comment);
			map.put("spring_rabbitmq_host", spring_rabbitmq_host);
			return map;
		}
}