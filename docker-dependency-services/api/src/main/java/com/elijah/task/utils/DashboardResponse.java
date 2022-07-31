package com.elijah.task.utils;

import com.elijah.task.*;

public class DashboardResponse {
    /*
    a Custom response class.
    */

	private final float loans;
        private final float paymentsSent;
        private final float paymentsRecieved;
        private final float total;

    public DashboardResponse(float loans, float paymentsSent, float paymentsRecieved, float total) {
        this.loans = loans;
        this.paymentsSent = paymentsSent;
        this.paymentsRecieved = paymentsRecieved;
        this.total = total;
    }

    public float getLoans() {
        return loans;
    }

    public float getPaymentsSent() {
        return paymentsSent;
    }

    public float getPaymentsRecieved() {
        return paymentsRecieved;
    }

    public float getTotal() {
        return total;
    }

    
}
