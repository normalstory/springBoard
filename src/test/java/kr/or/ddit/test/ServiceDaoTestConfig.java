package kr.or.ddit.test;

import static org.junit.Assert.assertFalse;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= 
		{"classpath:kr/or/ddit/config/spring/root-context.xml",
		 "classpath:kr/or/ddit/config/spring/transaction-context.xml",
		 
		 "classpath:kr/or/ddit/config/spring/batch-context.xml",		 
		 "classpath:kr/or/ddit/config/spring/datasource-test-context.xml"// <--test db 와 운영db 구분
		})
public class ServiceDaoTestConfig {

	@Resource(name="datasource")
	private DataSource datasource;
	
	@Before
	public void rangerSetup() {
		//데이터초기화
		//as-is: delete query 호출 -> to-be: sql 스크립트를 자동으로 실행 
		ResourceDatabasePopulator populater = new ResourceDatabasePopulator();
		populater.addScript(new ClassPathResource("/kr/or/ddit/config/db/dbInit.sql"));/*<- test resource 폴더에*/
		
		populater.setContinueOnError(false);
		
		DatabasePopulatorUtils.execute(populater,datasource);/*<- db연결정보 datasource- xml에서 주입받아사용*/
		
	}
	
	@Ignore
	@Test
	public void test() {
		assertFalse(!true);
	}
}
