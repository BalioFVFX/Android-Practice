package com.example.erik.mvp_dagger.main.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(value = RetentionPolicy.CLASS)
public @interface MVPDaggerScope {
}
