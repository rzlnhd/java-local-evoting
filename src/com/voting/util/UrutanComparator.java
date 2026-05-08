/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.util;

import com.voting.model.security.admin.Menu;
import java.util.Comparator;

/**
 *
 * @author ifnu
 */
public class UrutanComparator implements Comparator<Menu> {
    @Override
    public int compare(Menu o1, Menu o2) {
        int urutan = o1.getSort().compareTo(o2.getSort());
        if (urutan == 0) {
            if(o1.getParent()!=null && o2.getParent()!=null){
                return o1.getParent().getSort().compareTo(o2.getParent().getSort());
            }
            return o1.getId().compareTo(o2.getId());
        } else {
            return urutan;
        }
    }
}
