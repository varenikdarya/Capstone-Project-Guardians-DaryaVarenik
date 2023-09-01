package tek.sdet.framework.utilities;

import com.github.javafaker.Faker;

public class DataGenerator {

	public static String addressGenerator(String input) {

		Faker faker = new Faker();

		String output = "";

		if (input.equalsIgnoreCase("countryValue")) {
			output = "United States";
		} else if (input.equalsIgnoreCase("fullnameValue")) {
			output = faker.name().fullName();
		} else if (input.equalsIgnoreCase("phoneValue")) {
			output = faker.phoneNumber().cellPhone();
		} else if (input.equalsIgnoreCase("stAddress")) {
			output = faker.address().streetAddress();
		} else if (input.equalsIgnoreCase("aptValue")) {
			output = faker.address().secondaryAddress();
		} else if (input.equalsIgnoreCase("cityValue")) {
			output = faker.address().city();
		} else if (input.equalsIgnoreCase("stateValue")) {
			output = faker.address().state();
		} else if (input.equalsIgnoreCase("zipCodeValue")) {
			String zipcode = faker.address().zipCode().substring(0, 5);
			output = zipcode;
		}  else if (input.equalsIgnoreCase("nameValue")) {
			output = faker.name().firstName();
		} else if (input.equalsIgnoreCase("emailValue")) {
			output = faker.internet().emailAddress();
		} else if (input.equalsIgnoreCase("cardValue")) {
			output = faker.number().digits(16);
		}
		return output;
	}

	
	}
	
	
