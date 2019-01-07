package com.example.erik.locationmanager.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(value = RetentionPolicy.CLASS)
public @interface LocationScope {
}
