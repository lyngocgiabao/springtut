package rmit.team5.springtut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.aws.context.config.annotation.EnableContextCredentials;
import org.springframework.cloud.aws.context.config.annotation.EnableContextRegion;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EnableJpaRepositories
// enter the database name, database instance, username and password of Amazon RDS
@EnableRdsInstance(databaseName="team5", dbInstanceIdentifier="rmitttsproject", username="team5",password="team5Database!")
// enter the credentials here with access key and password (a.k.a secret key)
@EnableContextCredentials(accessKey="AKIAJF7V77GR6B52U53A", secretKey="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")
// the region of the instance
@EnableContextRegion(region="us-east-2")
public class SpringtutApplication extends ServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringtutApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringtutApplication.class, args);
	}

	// define message source bean
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	//register message source with LocalValidatorFactoryBean
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource);
		return bean;
	}

}
