/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.time.LocalDate;

/**
 *
 * @author zoranhome
 */
public  interface Persihable {
    
     public LocalDate parseDate(int year,int month,int day);
}
