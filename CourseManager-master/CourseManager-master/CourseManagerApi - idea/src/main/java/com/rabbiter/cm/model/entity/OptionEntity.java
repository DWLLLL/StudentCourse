package com.rabbiter.cm.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotNull;

@TableName("rc_option")
public class OptionEntity {
    @NotNull
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("option_key")
    private String optionKey;

    @TableField("option_value")
    private String optionValue;

    public OptionEntity(Integer id, String optionKey, String optionValue) {
        this.id = id;
        this.optionKey = optionKey;
        this.optionValue = optionValue;
    }

    public OptionEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
