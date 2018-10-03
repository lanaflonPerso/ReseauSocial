import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springsource.tcserver.serviceability.request.DataSource;

@Configuration
@ComponentScan("com.via.jdbc")
public class SpringJdbcConfig {
	@Bean
    public DriverManagerDataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Social");
        dataSource.setUsername("root");
        dataSource.setPassword("4fU1TLGv");
 
        return dataSource;
    }
	
}
