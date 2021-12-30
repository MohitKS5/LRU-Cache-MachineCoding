package CacheSystem;

public interface Cache {
    Cacheable get(String key);
    void put(String key, Cacheable value);
    void printAll();
}
