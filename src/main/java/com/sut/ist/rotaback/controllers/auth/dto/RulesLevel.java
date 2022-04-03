package com.sut.ist.rotaback.controllers.auth.dto;

public enum RulesLevel {
    ADMIN(5),
    MODERATOR(4),
    USER(3),
    MUTED(2),
    BANNED(1),
    UNAUTHORIZED(0);

    public final int value;

    RulesLevel(final int value) {this.value = value;}
}
