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

        static class comparePassengersByGenderThenPassengerNumber implements Comparator<Passenger> {
            @Override
            public int compare(Passenger a, Passenger b) {
                var ret = a.getGender().compareToIgnoreCase(b.getGender());
                if (ret != 0) return ret;
                ret = Integer.compare(Integer.parseInt(a.getPassengerId()), Integer.parseInt(b.getPassengerId()));
                if (ret != 0) return ret;
                else return 0;
            }
        }

        static class comparePassengersByFareThenSurvival implements Comparator<Passenger> {
            @Override
            public int compare(Passenger a, Passenger b) {
                var ret = Double.compare(a.getFare(), b.getFare());
                if (ret != 0) return ret;
                ret = Integer.compare(a.getSurvived(), b.getSurvived());
                if (ret != 0) return ret;
                else return 0;
            }
        }


    }
