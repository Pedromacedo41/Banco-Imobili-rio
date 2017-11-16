package com.BancoImobiliario.Comparators;
import com.BancoImobiliario.ClassesModels.Jogador;

import java.util.Comparator;

public class ComparatorDados implements Comparator<Jogador> {
    @Override
    public int compare(Jogador o1, Jogador o2) {
        if(o1.LancarDado1() <o2.LancarDado1()) return -1;
        else if(o1.LancarDado1() >o2.LancarDado1()) return +1;
        else return 0;
    }
}
