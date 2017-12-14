package tutorial;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class Tutorial {
	public static void main(String[] args) {
		String key = "k1";
		String value = "Hello world!";
		
		CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("hello-example");
		
		cache.put(key, value);
		cache.put("k2", "Second key");
		System.out.println((String)cache.get(key));
		System.out.println((String)cache.get("k2"));
		
		//testing invalid key
		System.out.println((String)cache.get("k3"));
		
		CacheFactory.shutdown();
	}
}
