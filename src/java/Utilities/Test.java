//        ADRA RWANDA.
//CORDAID RWANDA.
//FOOD FOR THE HUNGRY INTERNATIONAL/ RWANDA.
//INTRAHEALTH INTERNATIONAL.
//JHPIEGO (John Hopkins University)
//MEDICUS MUNDI.
//PLAN RWANDA (equipment)
//RURAL RWANDA DENTAL
package Utilities;

import Model.Domain.Account;
import Model.Domain.Donor;
import Model.Domain.Medicine;
import Model.Domain.Ngo;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        GenericDao<Donor> donorDao = new GenericDao<>(Donor.class);
        GenericDao<Medicine> medicineDao = new GenericDao<>(Medicine.class);
        GenericDao<Ngo> ngoDao = new GenericDao<>(Ngo.class);
        GenericDao<Account> accountDao = new GenericDao<>(Account.class);

        Ngo n1 = new Ngo("ADRA", "rs@2020", "ADRA RWANDA", "kacyiru", "07838382026");
        Ngo n2 = new Ngo("CORDAID", "rs@2020", "CORDAID RWANDA", "gikonda", "07838382026");
        Ngo n3 = new Ngo("INTRAHEALTH ", "rs@2020", "INTRAHEALTH INTERNATIONAL", "nyarugenge", "07838382026");

        Donor d1 = new Donor("ineza", "ineza", "ineza", "muhanga", "+250783832220");
        Donor d2 = new Donor("Belly", "belly", "belly clinic", "kimironko", "+250783832220");
        Donor d3 = new Donor("baho", "baho", "baho clinic", "remera", "+250783832220");

        donorDao.createX(d1);
        donorDao.createX(d2);
        donorDao.createX(d3);
        Medicine m1 = new Medicine("Acetaminophen", 250, new Date("02/06/2000"), new Date("02/06/2000"), d1);
        Medicine m2 = new Medicine("Amitriptyline", 250, new Date("02/06/2000"), new Date("02/06/2000"), d1);
        Medicine m3 = new Medicine("Adderall", 250, new Date("02/06/2000"), new Date("02/06/2000"), d2);
        Medicine m4 = new Medicine("Acetaminophen", 250, new Date("02/06/2000"), new Date("02/06/2000"), d2);
        Medicine m5 = new Medicine("Amitriptyline", 250, new Date("02/06/2000"), new Date("02/06/2000"), d3);
        Medicine m6 = new Medicine("Adderall", 250, new Date("02/06/2000"), new Date("02/06/2000"), d3);

        medicineDao.createX(m1);
        medicineDao.createX(m2);
        medicineDao.createX(m3);
        medicineDao.createX(m4);
        medicineDao.createX(m5);
        medicineDao.createX(m6);

        n1.requestMedicine(m1);
        n1.requestMedicine(m2);
        n2.requestMedicine(m1);
        n2.requestMedicine(m1);
        n3.requestMedicine(m3);
        n3.requestMedicine(m4);
        n3.requestMedicine(m5);
        n3.requestMedicine(m6);

        ngoDao.createX(n1);
        ngoDao.createX(n2);
        ngoDao.createX(n3);
Account acc1 = new Account(n1.getUserName(), n1.getPassword(), "Ngo");
Account acc2 = new Account(n2.getUserName(), n2.getPassword(), "Ngo");
Account acc3 = new Account(n3.getUserName(), n3.getPassword(), "Ngo");
Account acc4 = new Account(d1.getUserName(), d1.getPassword(), "Donor");
Account acc5 = new Account(d2.getUserName(), d2.getPassword(), "Donor");
Account acc6 = new Account(d3.getUserName(), d3.getPassword(), "Donor");
        accountDao.createX(acc1);
        accountDao.createX(acc2);
        accountDao.createX(acc3);
        accountDao.createX(acc4);
        accountDao.createX(acc5);
        accountDao.createX(acc6);

    }

}
