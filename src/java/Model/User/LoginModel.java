/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.User;

import Dao.AccountDao;
import Dao.DonorDao;
import Dao.NgoDao;
import Model.Domain.Account;
import Model.Domain.Donor;
import Model.Domain.Medicine;
import Model.Domain.Ngo;
import Model.Domain.User;
import Utilities.GenericDao;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mussa
 */
@ManagedBean(name = "lm")
@SessionScoped
public class LoginModel {

    /**
     * Creates a new instance of LoginModel
     */
    public LoginModel() {
    }
    private User user = new User();
    private Medicine medicine = new Medicine();
    DonorDao donorDao = new DonorDao(Donor.class);
    NgoDao ngoDao = new NgoDao(Ngo.class);
    AccountDao accDao = new AccountDao(Account.class);
    GenericDao<Donor> donorInfo = new GenericDao<>(Donor.class);
    GenericDao<Medicine> medicineInfo = new GenericDao<>(Medicine.class);
    GenericDao<Ngo> ngoInfo = new GenericDao<>(Ngo.class);
    GenericDao<Account> accounts = new GenericDao<>(Account.class);
    private String role;
    private String userName;
    private String password;

    public String signUp() {

        try {
            if (role.equalsIgnoreCase("Donor")) {
                donorDao.createX(Donor.builder()
                        .userName(user.getUserName())
                        .password(user.getPassword())
                        .location(user.getLocation())
                        .name(user.getName())
                        .contactNo(user.getContactNo())
                        .build()
                );
                Account account = new Account(user.getUserName(), user.getPassword(), "Donor");
                accDao.createX(account);
                return "Login.xhtml";

            } else if (role.equalsIgnoreCase("Ngo")) {
                ngoDao.createX(Ngo.builder()
                        .userName(user.getUserName())
                        .password(user.getPassword())
                        .location(user.getLocation())
                        .name(user.getName())
                        .contactNo(user.getContactNo())
                        .build()
                );
                Account account = new Account(user.getUserName(), user.getPassword(), "Ngo");
                accDao.createX(account);

                return "Login.xhtml";
            } else {
                FacesMessage msg = new FacesMessage("Not saved !!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "SignUp.xhtml";
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Not saved!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "SignUp.xhtml";
        }
    }

    public String signin() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            List<Account> account = accounts.findAll();
            for (Account acc : account) {
                if (userName.equals(acc.getUsername()) && password.equals(acc.getPassword())
                        && acc.getRole().equals("Ngo")) {
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    session.setAttribute("authenticatedUser", acc.getUsername());
//                    context.getExternalContext().getSessionMap().put("authenticatedUser", acc.getUsername());
                    return "NgoHome.xhtml";
                } else if (userName.equals(acc.getUsername()) && password.equals(acc.getPassword())
                        && acc.getRole().equals("Donor")) {
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    session.setAttribute("authenticatedUser", acc.getUsername());
//                    context.getExternalContext().getSessionMap().put("authenticatedUser", acc.getUsername());
                    return "DonorHome.xhtml";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage("Invalid username or password");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "Login.xhtml";
        }

        return "Login.xhtml";
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("Login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recordMedicine() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {

        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
