import CacheSystem.Cache;
import CacheSystem.CacheFactory;
import Entity.IntegerEntity;
import Entity.PersonEntity;

public class Main {
    public static void main(String[] args) {
        Cache cache = CacheFactory.createCache(CacheFactory.CacheType.MU, 3);
        cache.put("1", new IntegerEntity(1));
        cache.put("2", new IntegerEntity(2));
        cache.put("3", new IntegerEntity(3));
        cache.printAll();
        cache.put("4", new PersonEntity("Mohit", 23));
        cache.printAll();
        cache.get("4");
        cache.get("4");
        cache.get("3");
        cache.get("3");
        cache.get("2");
        cache.put("5", new IntegerEntity(5));
        cache.printAll();
    }
}
