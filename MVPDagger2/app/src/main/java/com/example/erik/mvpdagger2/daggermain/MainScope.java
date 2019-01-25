package com.example.erik.mvpdagger2.daggermain;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(value = RetentionPolicy.CLASS)
public @interface MainScope {
}
