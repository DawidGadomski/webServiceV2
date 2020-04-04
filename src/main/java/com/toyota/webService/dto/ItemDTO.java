package com.toyota.webService.dto;

import javax.validation.constraints.NotNull;

public class ItemDTO {
    @NotNull
    private String name;

    @NotNull
    private String code;

    public ItemDTO(@NotNull String name, @NotNull String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
