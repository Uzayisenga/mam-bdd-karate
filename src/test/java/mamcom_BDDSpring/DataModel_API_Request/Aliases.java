package mamcom_BDDSpring.DataModel_API_Request;

public class Aliases {

    private int id = 0;
    private String type = "LHCOM";
    private String aliasName;
    private String password = "Test@1234";

    public Aliases() {
    }

    public Aliases(int id, String type, String aliasName, String password) {
        this.id = id;
        this.type = type;
        this.aliasName = aliasName;
        this.password = password;
    }

    public Aliases(String aliasName) {
        this.aliasName = aliasName;

    }
}
