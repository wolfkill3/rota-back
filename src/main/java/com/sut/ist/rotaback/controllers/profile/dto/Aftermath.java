package com.sut.ist.rotaback.controllers.profile.dto;

public enum Aftermath {
    CRASH("Авария"),
    NO_CRASH("Без последствий");

    public final String result;

    Aftermath(final String result) {this.result = result;}

    public String fromBoolean(boolean cond) {
        if (cond) {
            return CRASH.result;
        } else {
            return NO_CRASH.result;
        }
    }
}
