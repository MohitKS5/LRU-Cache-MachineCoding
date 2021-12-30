package CacheSystem;

class LRUCache extends CacheImpl {
    CacheableListDecorator listHead, listTail;

    @Override
    protected void existingEntityAccessed(CacheableDecorator decorator) {
        CacheableListDecorator listDecorator = (CacheableListDecorator) decorator;
        if(listDecorator == listHead || listTail == listHead)
            return;
        if(listDecorator == listTail) {
            listTail = listTail.prev;
            listTail.next = null;
        }
       addAtFirst(listDecorator);
    }

    private void join(CacheableListDecorator left, CacheableListDecorator right) {
        if(left==null && right == null)
            return;
        if(left == null)
            right.prev = null;
        else if(right==null)
            left.next = null;
        else {
            left.next = right;
            right.prev = left;
        }
    }

    private void addAtFirst(CacheableListDecorator listDecorator) {
        join(listDecorator.prev, listDecorator.next);
        join(listDecorator, listHead);
        listHead = listDecorator;
        listHead.prev = null;
        if(listTail == null)
            listTail = listHead;
    }

    @Override
    protected CacheableDecorator newEntityAdded(String key, Cacheable cacheable) {
        CacheableListDecorator listDecorator = new CacheableListDecorator(key, cacheable);
        addAtFirst(listDecorator);
        return listDecorator;
    }

    @Override
    protected CacheableDecorator evict() {
        CacheableListDecorator evicted = listTail;
        listTail = listTail.prev;
        listTail.next = null;
        return evicted;
    }

    LRUCache(int capacity) {
        super(capacity);
    }
}
