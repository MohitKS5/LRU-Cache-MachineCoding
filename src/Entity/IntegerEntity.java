package Entity;

import CacheSystem.Cacheable;

public class IntegerEntity implements Cacheable {
    int value;

    @Override
    public void print() {
        System.out.printf("entity %s ", value);
    }

    public IntegerEntity(int value) {
        this.value = value;
    }
}
