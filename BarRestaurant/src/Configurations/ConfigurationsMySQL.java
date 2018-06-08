package Configurations;

public class ConfigurationsMySQL extends Configurations {
    public ConfigurationsMySQL(){
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        super.PASS = "mysql";
        super.PORT = "3306";
        super.BASE = "restaurant";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
}
