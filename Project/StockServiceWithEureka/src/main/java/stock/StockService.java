package stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	Logger logger = LoggerFactory.getLogger(StockService.class);

	public int getNumberOnStock(String productNumber) {
		return 8;
	}

	public Stock createStock(Stock stock) {
		logger.info("Create stock: " + stock);
		return stock;
	}
}
