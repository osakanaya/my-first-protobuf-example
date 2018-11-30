package uk.me.uohiro.protobuf.example;

import uk.me.uohiro.protobuf.example.model.PersonModel;

public class Main {
	public static void main(String[] args) throws Exception {
		PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
		builder.setId(1);
		builder.setName("Hideo Sashida");
		builder.setEmail("hideo@uohiro.me.uk");
		
		PersonModel.Person person = builder.build();
		System.out.println("before: " + person);
		
		System.out.println("===Person Byte:");
		for (byte b : person.toByteArray()) {
			System.out.print(b);
		}
		System.out.println("===");
		
		byte[] byteArray = person.toByteArray();
		PersonModel.Person person2 = PersonModel.Person.parseFrom(byteArray);
		
		System.out.println("after [id]" + person2.getId());
		System.out.println("after [name]" + person2.getName());
		System.out.println("after [email]" + person2.getEmail());
	}
}
