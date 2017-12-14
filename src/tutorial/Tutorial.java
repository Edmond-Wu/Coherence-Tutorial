package tutorial;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class Tutorial {
	public static void main(String[] args) {
		CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("my-cache");
		
		for (int i = 0; i < 10; i++) {
			String key = "k" + i;
			String val = "num" + i;
			cache.put(key, val);
		}
		
		for (Object k : cache.keySet()) {
			String keyVal = (String)k + ": " + (String)cache.get(k);
			System.out.println(keyVal);
		}
		
		CacheFactory.shutdown();
	}
}
