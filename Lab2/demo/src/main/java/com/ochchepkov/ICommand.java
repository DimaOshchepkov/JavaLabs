package com.ochchepkov;

@FunctionalInterface
public interface ICommand {
    void apply() throws IllegalArgumentException;
}
