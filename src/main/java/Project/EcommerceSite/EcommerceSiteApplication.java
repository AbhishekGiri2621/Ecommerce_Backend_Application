package Project.EcommerceSite;
import Project.EcommerceSite.model.TestEntity;
import Project.EcommerceSite.repository.TestEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceSiteApplication.class, args);
	}
	@Bean
	CommandLineRunner testData(TestEntityRepository repo) {
		return args -> {
			repo.save(new TestEntity("Hello World"));
			System.out.println("Test entity saved!");
		};
	}
}
