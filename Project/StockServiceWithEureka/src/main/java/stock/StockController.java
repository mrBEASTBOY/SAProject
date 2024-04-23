package stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import stock.StockService;


@RestController
@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService stockService;

	@GetMapping("/{productNumber}")
	public ResponseEntity<?> getStock(@PathVariable("productNumber") String productNumber) {
		int stock =stockService.getNumberOnStock(productNumber);
		return new ResponseEntity<Integer>(stock, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addStock(@RequestBody Stock stock) {
		return ResponseEntity.ok(stockService.createStock(stock));
	}
}
