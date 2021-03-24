
package Model.Domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author eddy
 */
@Entity
public class Administrator extends User implements Serializable {

    public Administrator() {
    }

//    public Administrator(String UserName, String password, String name, String location, String contactNo) {
//        super(UserName, password, name, location, contactNo);
//    }

 
   
}
