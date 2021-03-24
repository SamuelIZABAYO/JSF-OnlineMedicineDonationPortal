/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Domain.Donor;
import Utilities.GenericDao;

/**
 *
 * @author eddy
 */
public class DonorDao extends GenericDao<Donor>{
       
    public DonorDao(Class<Donor> type) {
        super(type);
    }
       
}
