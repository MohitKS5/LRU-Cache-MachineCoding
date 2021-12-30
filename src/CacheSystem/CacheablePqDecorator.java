package CacheSystem;

public class CacheablePqDecorator implements CacheableDecorator, Comparable<CacheablePqDecorator>{
    private String key;
    private Cacheable entity;
    public Integer accessCount = 0;

    public CacheablePqDecorator(String key, Cacheable entity) {
        this.key = key;
        this.entity = entity;
    }

    @Override
    public Cacheable getEntity() {
        return entity;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int compareTo(CacheablePqDecorator o) {
        return accessCount.compareTo(o.accessCount);
    }
}
