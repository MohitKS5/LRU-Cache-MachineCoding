package Entity;

import CacheSystem.Cacheable;

import java.util.UUID;

public class PersonEntity implements Cacheable {
    String id;
    String name;
    int age;

    public PersonEntity(String name, int age) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }

    @Override
    public void print() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
