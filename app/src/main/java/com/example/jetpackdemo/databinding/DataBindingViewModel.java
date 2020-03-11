package com.example.jetpackdemo.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataBindingViewModel extends ViewModel {
    private MutableLiveData<Integer> tickCxk, ticketJay;

    public MutableLiveData<Integer> getTickCxk() {
        if (tickCxk == null) {
            tickCxk = new MutableLiveData<>();
            tickCxk.setValue(0);
        }
        return tickCxk;
    }

    public MutableLiveData<Integer> getTicketJay() {
        if(ticketJay == null) {
            ticketJay = new MutableLiveData<>();
            ticketJay.setValue(0);
        }
        return ticketJay;
    }

    public void addJay() {
        if (ticketJay.getValue() != null) {
            ticketJay.setValue(ticketJay.getValue() + 1);
        }
    }

    public void addCxk() {
        if (tickCxk.getValue() != null) {
            tickCxk.setValue(tickCxk.getValue() + 1);
        }
    }
}
