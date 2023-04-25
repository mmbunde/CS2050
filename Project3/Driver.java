public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Creating profiles and adding to database.");
		Myles_BundeGreen_UserProfileManager m = new Myles_BundeGreen_UserProfileManager();

		Myles_BundeGreen_UserProfile john = new Myles_BundeGreen_UserProfile();
		john.setName("John", "Doe");
		john.setStatus("My name is John.");

		Myles_BundeGreen_UserProfile jane = new Myles_BundeGreen_UserProfile();
		jane.setName("Jane", "Doe");
		jane.setStatus("My name is Jane.");

		Myles_BundeGreen_UserProfile billy = new Myles_BundeGreen_UserProfile();
		billy.setName(new UserName("Billy", "Bob"));
		billy.setStatus("My name is Billy Bob!");
		
		Myles_BundeGreen_UserProfile smith = new Myles_BundeGreen_UserProfile();
		smith.setName(new UserName("John", "Smith"));
		smith.setStatus("My name is also John.");

		m.addProfile(john);
		m.addProfile(jane);
		m.addProfile(billy);
		m.addProfile(smith);
		//m.display();
		System.out.println(john.getStatus());
		System.out.println("-------------------------------------\n");
		System.out.println("Creating friendships.\n");

		m.createFriendship(john, jane);
		m.createFriendship(jane, billy);
		m.createFriendship(john, smith);
		m.createFriendship(smith, jane);
		m.createFriendship(billy, smith);

		//m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Changing statuses / names.\n");
		
		smith.setStatus("Just got married!");
		jane.setStatus("Now Mrs. Smith!");
		jane.setName("Jane", "Smith");

		//m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Ending a friendship.\n");
		
		m.endFriendship(john, billy);
		
		//m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Removing John.\n");
		m.removeProfile(john);

		//m.display();
	} // end main
} // end Driver

/*
Creating profiles and adding to database.
UserName: John Doe
	Status: My name is John.
	Picture: BufferedImage@52e922
	# of friends: 0
Friends:

UserName: Jane Doe
	Status: My name is Jane.
	Picture: BufferedImage@25154f
	# of friends: 0
Friends:

UserName: Billy Bob
	Status: My name is Billy Bob!
	Picture: BufferedImage@10dea4
	# of friends: 0
Friends:

UserName: John Smith
	Status: My name is also John.
	Picture: BufferedImage@647e05
	# of friends: 0
Friends:

-------------------------------------

Creating friendships.

UserName: John Doe
	Status: My name is John.
	Picture: BufferedImage@52e922
	# of friends: 2
Friends:
	Jane Doe
	John Smith

UserName: Jane Doe
	Status: My name is Jane.
	Picture: BufferedImage@25154f
	# of friends: 3
Friends:
	John Doe
	Billy Bob
	John Smith

UserName: Billy Bob
	Status: My name is Billy Bob!
	Picture: BufferedImage@10dea4
	# of friends: 2
Friends:
	Jane Doe
	John Smith

UserName: John Smith
	Status: My name is also John.
	Picture: BufferedImage@647e05
	# of friends: 3
Friends:
	John Doe
	Jane Doe
	Billy Bob

-------------------------------------

Changing statuses / names.

UserName: John Doe
	Status: My name is John.
	Picture: BufferedImage@52e922
	# of friends: 2
Friends:
	Jane Smith
	John Smith

UserName: Jane Smith
	Status: Now Mrs. Smith!
	Picture: BufferedImage@25154f
	# of friends: 3
Friends:
	John Doe
	Billy Bob
	John Smith

UserName: Billy Bob
	Status: My name is Billy Bob!
	Picture: BufferedImage@10dea4
	# of friends: 2
Friends:
	Jane Smith
	John Smith

UserName: John Smith
	Status: Just got married!
	Picture: BufferedImage@647e05
	# of friends: 3
Friends:
	John Doe
	Jane Smith
	Billy Bob

-------------------------------------

Ending a friendship.

UserName: John Doe
	Status: My name is John.
	Picture: BufferedImage@52e922
	# of friends: 2
Friends:
	Jane Smith
	John Smith

UserName: Jane Smith
	Status: Now Mrs. Smith!
	Picture: BufferedImage@25154f
	# of friends: 3
Friends:
	John Doe
	Billy Bob
	John Smith

UserName: Billy Bob
	Status: My name is Billy Bob!
	Picture: BufferedImage@10dea4
	# of friends: 2
Friends:
	Jane Smith
	John Smith

UserName: John Smith
	Status: Just got married!
	Picture: BufferedImage@647e05
	# of friends: 3
Friends:
	John Doe
	Jane Smith
	Billy Bob

-------------------------------------

Removing John.

UserName: Jane Smith
	Status: Now Mrs. Smith!
	Picture: BufferedImage@25154f
	# of friends: 2
Friends:
	Billy Bob
	John Smith

UserName: Billy Bob
	Status: My name is Billy Bob!
	Picture: BufferedImage@10dea4
	# of friends: 2
Friends:
	Jane Smith
	John Smith

UserName: John Smith
	Status: Just got married!
	Picture: BufferedImage@647e05
	# of friends: 2
Friends:
	Jane Smith
	Billy Bob


 */
