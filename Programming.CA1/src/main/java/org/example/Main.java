package org.example;

import java.awt.*;
import java.io. * ;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        String fileName = "titanic-data-100.csv"; // file should be in the project folder (below pom.xml)

        ArrayList<Passenger> passengerList = new ArrayList<>();

        loadPassengerDataFromFile( passengerList, fileName);

        //displayAllPassengers( passengerList );

        // Assignment: Implement and test the following methods

//        getPassengerNames();
        System.out.println("1:");
        System.out.println(Arrays.toString(getpassengernames(passengerList)));

//        getPassengersContainingNames();
        System.out.println("2:");
        String targetName ="Rogers";
        System.out.println(getNameContaining(passengerList,targetName));

//        getPassengersOlderThan();
        System.out.println("3:");
        int age=45;
        System.out.println(getPassengersOlderThan(passengerList,age));

//        countPassengersByGender();
        System.out.println("4:");
        String gender = "female";
        System.out.println(countPassengersByGender(passengerList,gender));

//        sumFares();
        System.out.println("5:");
        System.out.println(sumFares(passengerList));

//        maleSurvivors();
        System.out.println("6:");
        System.out.println(Arrays.toString(maleSurvivors(passengerList)));

//        ticketOwner();
        System.out.println("7:");
        int ticketNum =345763;
        System.out.println(ticketOwner(passengerList, ticketNum));

//        averageAge();
        System.out.println("8:");
        System.out.println(averageAge(passengerList));

//        getPassengersByTicketClass();
        System.out.println("9:");
        System.out.println(getPassengersByTicketClass(passengerList, PassengerClass.FIRST));

//        sortPassengersByPassengerId()
        System.out.println("10:");
        System.out.println(sortPassengersByPassengerId(passengerList));

//        sortPassengersByName();
        System.out.println("11:");
        System.out.println(sortPassengersByName(passengerList));

//        sortPassengersByAgeThenName();
        System.out.println("12:");
        System.out.println(sortPassengersByAgeThenName(passengerList));

//        sortPassengersByGenderThenPassengerNumber()
//        sortPassengersByFareThenSurvival();
//        sortPassengersByTicketClass()
//        sortPassengersByAge();
//        sortPassengersByTicketNumberLambda();
//        sortPassengersByTicketNumberStatic();
//        findPassengerByTicketNumber();
//        findPassengerByPassengerId();




    }

    public static void loadPassengerDataFromFile( ArrayList<Passenger> passengerList, String fileName) {

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // John Malone,20,1.78,3.55   for example

        // Use a Regular Expression to set both comma and newline as delimiters.
        //  sc.useDelimiter("[,\\r\\n]+");
        // Text files in windows have lines ending with "CR-LF" or "\r\n" sequences.
        // or may have only a newline - "\n"
        // Windows uses CRLF (\r\n, 0D 0A) line endings while Unix just uses LF (\n, 0A).
        //
        try (Scanner sc = new Scanner(new File(fileName))
                .useDelimiter("[,\\r\\n]+"))
        {

            // skip past the first line, as it has field names (not data)
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // while there is a next token to read....
            System.out.println("Go...");

            while (sc.hasNext())
            {
                String passengerId = sc.next();    // read passenger ID
                int survived = sc.nextInt();     // 0=false, 1=true
                int passengerClass = sc.nextInt();  // passenger class, 1=1st, 2=2nd or 3rd
                String name = sc.next();
                String gender = sc.next();
                int age = sc.nextInt();
                int siblingsAndSpouses = sc.nextInt();
                int parentsAndChildren = sc.nextInt();
                String ticketNumber = sc.next();
                double fare = sc.nextDouble();
                String cabin = sc.next();
                String embarkedAt = sc.next();

                System.out.println(passengerId +", " + name);

                passengerList.add(
                        new Passenger( passengerId, survived, passengerClass,
                                name, gender, age, siblingsAndSpouses,parentsAndChildren,ticketNumber,
                                fare, cabin, embarkedAt)
                );
            }
        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }

    public static void displayAllPassengers( ArrayList<Passenger> passengerList ) {
        for( Passenger passenger : passengerList)
        {
            System.out.println(passenger);
        }
    }

    public static String[] getpassengernames(ArrayList<Passenger> passengerList)
    {
        String[] names = new String[passengerList.size()];
        for (int i=0; i< passengerList.size(); i++)
        {
            names[i] = passengerList.get(i).getName();
        }
        return names;
    }

    public static ArrayList<Passenger> getNameContaining(ArrayList<Passenger> passengerList, String targetName)
    {
        ArrayList<Passenger> namesContainingX = new ArrayList<>();

        for (int i=0; i< passengerList.size(); i++)
        {
            if (passengerList.get(i).getName().contains(targetName))
            {
                namesContainingX.add(passengerList.get(i));
            }
        }
        return namesContainingX;
    }

    public static ArrayList<Passenger> getPassengersOlderThan(ArrayList<Passenger> passengerList, int age)
    {
        ArrayList<Passenger> olderThanX = new ArrayList<>();

        for (int i=0; i<passengerList.size(); i++)
        {
            if (passengerList.get(i).getAge()>age)
            {
                olderThanX.add(passengerList.get(i));
            }
        }
        return olderThanX;
    }

    public static ArrayList<Passenger> countPassengersByGender(ArrayList<Passenger> passengerList,String gender)
    {
        ArrayList<Passenger> passengerByGender = new ArrayList<>();
        for (int i=0; i<passengerList.size(); i++)
        {
            if(passengerList.get(i).getGender().equalsIgnoreCase(gender))
            {
                passengerByGender.add(passengerList.get(i));
            }
        }
        return passengerByGender;
    }

    public static double sumFares(ArrayList<Passenger> passengerList)
    {
        double sum=0;
        for (int i=0; i<passengerList.size(); i++)
        {
            sum = sum + passengerList.get(i).getFare();
        }
        return sum;
    }

    public static String[] maleSurvivors(ArrayList<Passenger> passengerList)
    {
        ArrayList<String> maleSurvivorsList = new ArrayList<>();

        for (int i=0; i<passengerList.size(); i++)
        {
            if(passengerList.get(i).getSurvived() == 1 && passengerList.get(i).getGender().equalsIgnoreCase("male"))
            {
                maleSurvivorsList.add(passengerList.get(i).getName());
            }
        }

        String[] maleSurvivors = new String[maleSurvivorsList.size()];
        for (int i=0; i<maleSurvivorsList.size(); i++)
        {
            maleSurvivors[i] = maleSurvivorsList.get(i);
        }
        return maleSurvivors;
    }

    public static ArrayList<Passenger> ticketOwner(ArrayList<Passenger> passengerList, int ticketNum)
    {
        ArrayList<Passenger> ticketOwner = new ArrayList<>();
        for (int i=0; i<passengerList.size(); i++)
        {
            if(passengerList.get(i).getTicketNumber().equals(""+ticketNum))
            {
                ticketOwner.add(passengerList.get(i));
            }
        }
        return ticketOwner;
    }

    public static double averageAge(ArrayList<Passenger> passengerList)
    {
        double totalAge=0;
        for (Passenger passenger : passengerList)
        {
            totalAge=totalAge+passenger.getAge();
        }
        return totalAge/passengerList.size();
    }

    public static ArrayList<Passenger> getPassengersByTicketClass(ArrayList<Passenger> passengerList, PassengerClass value)
    {
        ArrayList<Passenger> passengerenum = new ArrayList<>();
        for (Passenger passenger : passengerList)
        {
            if(passenger.getPassengerClass()==value)
            {
                passengerenum.add(passenger);
            }
        }
        return passengerenum;
    }

    public static ArrayList<Passenger> sortPassengersByPassengerId(ArrayList<Passenger> passengerList) {
        Collections.sort(passengerList);
        ArrayList<Passenger> sortedId = new ArrayList<>();
        for (Passenger passenger : passengerList)
        {
            sortedId=passengerList;
        }
        return sortedId;
    }

    public static ArrayList<Passenger> sortPassengersByName(ArrayList<Passenger> passengerList)
    {
        Collections.sort(passengerList, new compareToNames());
        ArrayList<Passenger> sortedNames = new ArrayList<>();
        for (Passenger passenger : passengerList)
        {
            sortedNames=passengerList;
        }
        return sortedNames;
    }

    public static ArrayList<Passenger> sortPassengersByAgeThenName(ArrayList<Passenger> passengerList)
    {
        Collections.sort(passengerList, new compareToNames.compareAgeThenName());
        return passengerList;
    }
}