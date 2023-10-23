package com.ochchepkov;

@FunctionalInterface
public interface IComand<T, U> {
    T apply(U value);
}
