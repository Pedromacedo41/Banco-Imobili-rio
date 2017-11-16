package com.BancoImobiliario.Comparators;

import com.BancoImobiliario.ClassesModels.Casa;

import java.util.Comparator;

public class ComparatorPosicao implements Comparator <Casa> {

    @Override
    public int compare(Casa o1, Casa o2) {
        if(o1.getNumeracao()<o2.getNumeracao()) return -1;
        else if(o1.getNumeracao() >o2.getNumeracao()) return +1;
        else return 0;
    }
}
