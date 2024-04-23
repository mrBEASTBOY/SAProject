package contacts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String productUrl = "http://localhost:8902/product";
		String productQueryUrl = "http://localhost:8901/product";
		String stockUrl = "http://localhost:8900/stock";


		for(int i =0;i < 1000; i++){
			// add Product 1
			restTemplate.postForLocation(productUrl, new Product("Frank","i", 1.2,0));
			// add Product 2
			restTemplate.postForLocation(productUrl, new Product( "John","i+1000",2.02,0));

			// add product 1 - stock: 10
			restTemplate.postForLocation(stockUrl, new Stock("i",10));
			// add product 2 - stock: 5
			restTemplate.postForLocation(stockUrl, new Stock("i+1000",5));
		}


		//sleep 15 seconds
		Thread.sleep(15000);

		// get Product 1 detail from ProductQueryService
		Product book = restTemplate.getForObject(productUrl+"/{isbn}", Product.class, "1");
		Product book1 = restTemplate.getForObject(productUrl+"/{isbn}", Product.class, "2");
		System.out.println("----------- get Product -----------------------");
		System.out.println(book);
		System.out.println(book1);
	}

}
