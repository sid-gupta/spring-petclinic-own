package com.siddharth.spring.springpetclinic.services.map;

import com.siddharth.spring.springpetclinic.model.BaseEntity;
import com.siddharth.spring.springpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    protected Map<Long, T> map = new HashMap();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if (object == null) {
            throw new RuntimeException("Object cannot be null.");
        }
        if (object.getId() == null) {
            object.setId(getNextID());
        }
        map.put(object.getId(), object);
        return object;
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextID() {
        if (map.size() == 0) {
            return 1L;
        }
        Long maxId = Collections.max(map.keySet());
        return maxId + 1;
    }
}
