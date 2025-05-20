package com.dante.mcc_customer_service.utils;

import java.util.List;
import java.util.Optional;

public interface ICrud<T> {

    List<T> getAll();

    T add(T t);

    T update(T t);

    T delete(T t);

    T getById(String id);
}
