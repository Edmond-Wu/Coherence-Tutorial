package objects;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

/**
 * POJO class to be used in Coherence Tutorial
 * @author ewu
 */
public class Person implements PortableObject {
	private String firstName;
	private String lastName;
	private int salary;
	private Address address;

	public Person() {

	}

	public Person(String firstName, String lastName, int salary, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.setAddress(address);
	}

	// ------------------- GETTERS/SETTERS ---------------------

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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// ----------------- OBJECT METHODS --------------------

	public String toString() {
		return this.firstName + " " + this.lastName + ", salary: " + this.salary + "\n address: " + this.address.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + salary;
		return result;
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (salary != other.salary)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

	@Override
	public void readExternal(PofReader reader) throws IOException {
		setFirstName(reader.readString(0));
		setLastName(reader.readString(1));
		setSalary(reader.readInt(2));
		setAddress((Address)reader.readObject(3));
	}

	@Override
	public void writeExternal(PofWriter writer) throws IOException {
		writer.writeString(0, this.firstName);
		writer.writeString(1, this.lastName);
		writer.writeInt(2, this.salary);
		writer.writeObject(3, this.address);
	}
}
