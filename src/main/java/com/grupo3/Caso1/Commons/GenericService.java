package com.grupo3.Caso1.Commons;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {
    // Metodos generales de crud
    T save(T entity);

    void delete(ID id);

    T get(ID id);

    List<T> getAll();

}