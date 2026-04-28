import java.util.Objects;

public class Person<K> implements KeyedElementInterface<K> {

	private String firstName;
	private String lastName;
	private K key;
	
	
	
	public Person(String firstName, String lastName, K key) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.key = key;
	}
	
	

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public KeyedElementInterface<K> copy() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int hashCode() {
		
		int num = 1;
		
		num = (num + firstName.length()) * 13;
		num = (num + lastName.length()) * 13; 
		//return Objects.hash(firstName, key, lastName);
		return num;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(key, other.key)
				&& Objects.equals(lastName, other.lastName);
	}

	
	
}
