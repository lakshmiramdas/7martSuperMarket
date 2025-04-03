package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	
	public String getFakeCategoryName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.firstName();

		return text;

	}
public String getPassword() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.lastName();

		return text;
}
public String getFakeCityName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.cityName();

		return text;

	}
public String getFakeProductName() {

	Faker faker = new Faker();

	Address address = faker.address();

	String text = faker.food ().ingredient();		
	
	return text;
}

}
