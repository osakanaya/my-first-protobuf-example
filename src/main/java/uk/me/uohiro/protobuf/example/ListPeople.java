package uk.me.uohiro.protobuf.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import uk.me.uohiro.protobuf.example.model.AddressBookProtos.AddressBook;
import uk.me.uohiro.protobuf.example.model.AddressBookProtos.Person;

public class ListPeople {
	
	static void print(AddressBook addressBook) {
		for(Person person : addressBook.getPeopleList()) {
			System.out.println("Person ID: " + person.getId());
			System.out.println("  Name: " + person.getName());
			if (person.hasEmail()) {
				System.out.println("  E-mail address: " + person.getEmail());
			}
			
			for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
				switch (phoneNumber.getType()) {
					case MOBILE:
						System.out.print("  Mobile phone #: ");
						break;
					case HOME:
						System.out.print("  Home phone #: ");
						break;
					case WORK:
						System.out.print("  Work phone #: ");
						break;
				}
				System.out.println(phoneNumber.getNumber());
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		if (args.length != 1) {
			System.err.println("Usage: ListPeople ADDRESS_BOOK_FILE");
			System.exit(-1);
		}
		
		AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(args[0]));
		
		print(addressBook);
	}

}
