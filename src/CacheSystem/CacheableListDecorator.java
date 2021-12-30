package CacheSystem;

import java.util.Objects;

class CacheableListDecorator implements CacheableDecorator{

    private Cacheable entity;
    private String key;

    public CacheableListDecorator next;
    public CacheableListDecorator prev;

    @Override
    public Cacheable getEntity() {
        return entity;
    }

    @Override
    public String getKey() {
        return key;
    }

    public CacheableListDecorator(String key, Cacheable entity) {
        this.entity = entity;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheableListDecorator that = (CacheableListDecorator) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
