/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elijah.task.utils;

/**
 *
 * @author elijah
 */


public abstract class Enums{
    /*
    An abstrac class for channel and loan status choices.
    */
    public enum Channel {
        MOBILE, BANK
    }

    public enum Direction {
        SENDING, RECEIVING   
    }
    
    public enum LoanStatus {
        PENDING_DISBURSAL, DISBURSED, REPAID,
        DEFAULTED
    }
}
