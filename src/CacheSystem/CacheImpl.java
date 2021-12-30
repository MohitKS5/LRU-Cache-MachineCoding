package CacheSystem;

import java.util.HashMap;
import java.util.Map;

abstract class CacheImpl implements Cache {
    protected Map<String, CacheableDecorator> cacheableDecoratorMap = new HashMap<>();
    protected int currentSize;
    protected int capacity;

    public CacheImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Cacheable get(String key) {
        if(cacheableDecoratorMap.containsKey(key)){
            CacheableDecorator decorator = cacheableDecoratorMap.get(key);
            existingEntityAccessed(decorator);
        }
        return null;
    }

    @Override
    public void put(String key, Cacheable value) {
        if(cacheableDecoratorMap.containsKey(key)){
            CacheableDecorator decorator = cacheableDecoratorMap.get(key);
            existingEntityAccessed(decorator);
        } else {
            if(isFull()) {
                CacheableDecorator evictedDecorator = evict();
                cacheableDecoratorMap.remove(evictedDecorator.getKey());
            }
            CacheableDecorator newEntity = newEntityAdded(key, value);
            cacheableDecoratorMap.put(key, newEntity);
            currentSize++;
        }
    }

    private boolean isFull() {
        return currentSize >= capacity;
    }

    public void printAll() {
        System.out.println("Cache Start");
        cacheableDecoratorMap.values().forEach(decorator -> {
            System.out.printf("key: %s ", decorator.getKey());
            decorator.getEntity().print();
        });
        System.out.println("\nCache End\n");
    }

    protected abstract void existingEntityAccessed(CacheableDecorator decorator);
    protected abstract CacheableDecorator newEntityAdded(String key, Cacheable cacheable);
    protected abstract CacheableDecorator evict();
}
