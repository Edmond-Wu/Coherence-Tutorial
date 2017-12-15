package tutorial;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

import models.Address;
import models.Person;

public class TutorialWithObjects {
	public static void main(String[] args) {
		CacheFactory.ensureCluster();
		NamedCache personCache = CacheFactory.getCache("person-cache");
		
		Address addr = new Address("77 River Road", "Clifton", "NJ", "07014");
		Person pers = new Person("Edmond", "Wu", 1000000, addr);
		personCache.put(pers.getFirstName(), pers);
		Person pers2 = (Person)personCache.get(pers.getFirstName());
		if (pers.equals(pers2)) {
			System.out.println("Same person");
		}
		
		CacheFactory.shutdown();
	}
}
