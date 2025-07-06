package com.mamcom_BDDSpring.dataProvider;

import com.mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@PageObjects

public class SanpleClass {
    private int id = 0;
    private String type = "ONEID";
    private String aliasName;
    private String password = "Test@1234";
    public SanpleClass() {
    }
    public SanpleClass(int id, String type, String aliasName, String password) {
        this.id = id;
        this.type = type;
        this.aliasName = aliasName;
        this.password = password;
    }
    public SanpleClass(String aliasName) {
        this.aliasName = aliasName;
    }

}
