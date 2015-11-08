package com.tcode.common.strategy;

/**
 * Created by Sergey Roshchupkin on 11/7/2015.
 */
public interface Action<T, V> {
    T execute(T entity, V value);
}