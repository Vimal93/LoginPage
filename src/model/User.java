package model;

public class User {
	private String name;
	private String firstName;
	private String lastName;
	private int Id;
	public User()
	{
		this.name="";
	}
	public User(int Id, String name, String firstName, String lastName)
	{
	    this.Id=Id;
		this.name = name;
	    this.firstName=firstName;
	    this.lastName=lastName;
	}
	public void setName(String name)
	{
	    this.name = name;
	}
	public String getName()
	{
	    return name;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public int getId()
	{
		return Id;
	}
}


