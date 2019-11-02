package com.cyntex.TourismApp.Beans;

public class AuthenticatedUserBean extends UserBean {
    private final String password;
    private final String pwdSalt;
    private final int isAdmin;

    public AuthenticatedUserBean(String email, String firstName, String lastName, String phone, String country,
                                 String gender,
                                 String imageUrl,
                                 String password,
                                 String pwdSalt, int isAdmin) {
        super(email, firstName, lastName, phone, country, gender, imageUrl);
        this.password = password;
        this.pwdSalt = pwdSalt;
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public int getIsAdmin() {
        return isAdmin;
    }
}
