package products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("/{productNumber}")
	public ResponseEntity<?> getProduct(@PathVariable("productNumber") String productNumber) {
		Product product =productService.getProduct(productNumber);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createProduct(@RequestBody Product p) {
		Product product =productService.createProduct(p);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
