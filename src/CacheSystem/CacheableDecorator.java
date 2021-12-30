package CacheSystem;

interface CacheableDecorator {
    Cacheable getEntity();
    String getKey();
}
