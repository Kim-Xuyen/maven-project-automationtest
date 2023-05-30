package com.nopcommerce.user;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class Level_19_Fake {
	public static void main(String[] args) {
		Faker faker = new Faker();
		Address address = faker.address();

		System.out.println(address.firstName());
		System.out.println(address.lastName());
	}
}