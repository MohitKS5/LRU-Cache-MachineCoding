package CacheSystem;

import java.util.PriorityQueue;

public class MUCache extends CacheImpl{
    PriorityQueue<CacheablePqDecorator> cacheablePriorityQueue = new PriorityQueue<>(capacity);

    public MUCache(int capacity) {
        super(capacity);
    }

    @Override
    protected void existingEntityAccessed(CacheableDecorator decorator) {
        CacheablePqDecorator pqDecorator = (CacheablePqDecorator) decorator;
        cacheablePriorityQueue.remove(pqDecorator);
        pqDecorator.accessCount++;
        cacheablePriorityQueue.add(pqDecorator);
    }

    @Override
    protected CacheableDecorator newEntityAdded(String key, Cacheable cacheable) {
        CacheablePqDecorator pqDecorator = new CacheablePqDecorator(key, cacheable);
        cacheablePriorityQueue.add(pqDecorator);
        return pqDecorator;
    }

    @Override
    protected CacheableDecorator evict() {
        return cacheablePriorityQueue.poll();
    }
}
