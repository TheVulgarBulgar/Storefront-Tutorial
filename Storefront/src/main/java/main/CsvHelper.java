package main;

import java.io.File;
import java.util.Map;

import org.springframework.context.annotation.Bean;

public class CsvHelper {

	@Bean
	public File csvToProduct(File message) {
		return message;
	}
}
