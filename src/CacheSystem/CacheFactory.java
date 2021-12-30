package CacheSystem;

public class CacheFactory {
    public enum CacheType {LRU, MU}

    public static Cache createCache(CacheType cacheType, int capacity) {
        switch (cacheType) {
            case LRU -> {
                return new LRUCache(capacity);
            }
            case MU -> {
                return new MUCache(capacity);
            }
            default -> {
                throw new RuntimeException("Unknown Cache type !");
            }
        }
    }
}
