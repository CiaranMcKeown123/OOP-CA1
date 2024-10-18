package org.example;

import java.util.Comparator;

    class compareToNames implements Comparator<Passenger> {
        @Override
        public int compare(Passenger a, Passenger b) {
            return a.getName().compareTo(b.getName());
    }
    }