package mamcom_BDDSpring.dataProvider;

import mamcom_BDDSpring.annotations.PageObjects;
import lombok.Data;

@Data
@PageObjects
public class updateUser {

    private int id = 0;
    private String type="ONEID";
    private String aliasName="testsample1@yopmail.com";
    private String password="Test@1234";

}

