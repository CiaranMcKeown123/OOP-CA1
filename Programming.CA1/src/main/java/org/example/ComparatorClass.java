package org.example;

import java.util.Comparator;

    class compareToNames implements Comparator<Passenger> {
        @Override
        public int compare(Passenger a, Passenger b) {
            return a.getName().compareTo(b.getName());
        }

        static class compareAgeThenName implements Comparator<Passenger> {
            @Override
            public int compare(Passenger a, Passenger b) {
                var ret = Integer.compare(a.getAge(), b.getAge());
                if (ret != 0) return ret;
                ret = a.getName().compareToIgnoreCase(b.getName());
                if (ret != 0) return ret;
                else return 0;
            }
        }
    }
