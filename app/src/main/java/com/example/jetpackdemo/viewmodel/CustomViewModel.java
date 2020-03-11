package com.example.jetpackdemo.viewmodel;

import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {
    private int ticketCxk = 0;
    private int ticketJay = 0;

    public int getTicketCxk() {
        return ticketCxk;
    }

    public void setTicketCxk(int ticketCxk) {
        this.ticketCxk = ticketCxk;
    }

    public int getTicketJay() {
        return ticketJay;
    }

    public void setTicketJay(int ticketJay) {
        this.ticketJay = ticketJay;
    }
}
