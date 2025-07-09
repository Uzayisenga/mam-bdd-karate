package mamcom_BDDSpring.DataModel_API_Request;

import lombok.Data;
import mamcom_BDDSpring.annotations.PageObjects;

@Data
@PageObjects
public class EnrolmentAliasesFFP {
        private int id = 0;
        private String type = "LHCOM";
        private String aliasName;
        private String password ;

        public EnrolmentAliasesFFP() {}

        public EnrolmentAliasesFFP(int id, String type, String aliasName, String password) {
            this.id = id;
            this.type = type;
            this.aliasName = aliasName;
            this.password = password;
        }

        public EnrolmentAliasesFFP(String aliasName, String password) {
            this.aliasName = aliasName;
            this.password = password;
            System.out.println(aliasName);

        }

}
