package dao;

public class UserDaoOracleIpml implements UserDAO {
    public void getUser() {
        System.out.println("使用Oracle");
    }
    public UserDaoOracleIpml(){
        System.out.println("默认");
    }
}
