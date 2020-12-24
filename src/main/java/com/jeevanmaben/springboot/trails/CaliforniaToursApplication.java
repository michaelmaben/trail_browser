package com.jeevanmaben.springboot.trails;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeevanmaben.springboot.trails.service.TourPackageService;
import com.jeevanmaben.springboot.trails.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class CaliforniaToursApplication implements CommandLineRunner {

	@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;
	@Value("#{trails.importfile}")
	private String importJSONFile;

	public static void main(String[] args) {
		SpringApplication.run(CaliforniaToursApplication.class, args);
	}

	public void run(String... args){
		createTourPackages();
		createTours(importJSONFile);
	}

	private void createTourPackages(){
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
	}

	private void createTours(String importJSONFile){
		try {
			TrailReader.readFile(importJSONFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class TrailReader{
		private String packageType, title, description, blurb, price, length,
				bullets, keywords, difficulty, region;

		public String getPackageType() {
			return packageType;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public String getBlurb() {
			return blurb;
		}

		public String getPrice() {
			return price;
		}

		public String getLength() {
			return length;
		}

		public String getBullets() {
			return bullets;
		}

		public String getKeywords() {
			return keywords;
		}

		public String getDifficulty() {
			return difficulty;
		}

		public String getRegion() {
			return region;
		}

		static List<TrailReader> readFile(String fileName) throws IOException {
			return new ObjectMapper().setVisibility(FIELD, JsonAutoDetect.Visibility.ANY)
					.readValue(new FileInputStream(fileName),
							new TypeReference<List<TrailReader>>(){});
		}
	}

}
