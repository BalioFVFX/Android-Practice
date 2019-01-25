package com.example.network.daggernetwork;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(value = RetentionPolicy.CLASS)
public @interface NetworkScope {
}
