package com.rabbiter.cm.model.vo.request;


import javax.validation.constraints.NotNull;

public class BoolOptionVO {
    @NotNull
    public Boolean option;

    public Boolean getOption() {
        return option;
    }

    public void setOption(Boolean option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "BoolOptionVO{" +
                "option=" + option +
                '}';
    }
}
