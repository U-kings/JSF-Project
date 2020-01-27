/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lenovo.bean;

import com.lenovo.model.PartTypes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author UCHE
 */
@Stateless
public class PartTypesFacade extends AbstractFacade<PartTypes> {

    @PersistenceContext(unitName = "LenovoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PartTypesFacade() {
        super(PartTypes.class);
    }
    
}
