package lab3;

import java.util.LinkedList;

public class Animals {
    public static void main(String[] args) {
        LinkedList<Mammals> srcCollection1 = new LinkedList<>();
        srcCollection1.add(new Manul("manul1"));
        srcCollection1.add(new Manul("manul2"));
        srcCollection1.add(new Manul("manul3"));
        srcCollection1.add(new Lynx("lynx1"));
        srcCollection1.add(new Lynx("lynx2"));
        srcCollection1.add(new Lynx("lynx3"));
        srcCollection1.add(new EuropeanHedgehog("hedgehog1"));
        srcCollection1.add(new EuropeanHedgehog("hedgehog2"));
        srcCollection1.add(new EuropeanHedgehog("hedgehog3"));

        LinkedList<Hedgehogs> collectionOfHedgehogs = new LinkedList<>();
        LinkedList<Feline> collectionOfFeline = new LinkedList<>();
        LinkedList<Predatory> collectionOfPredators = new LinkedList<>();

        segregate(srcCollection1, collectionOfHedgehogs, collectionOfFeline, collectionOfPredators);

        System.out.println(srcCollection1);
        System.out.println(collectionOfFeline);
        System.out.println(collectionOfHedgehogs);
        System.out.println(collectionOfPredators);

        LinkedList<Predatory> srcCollection2 = new LinkedList<>();
        srcCollection2.add(new Manul("manul1"));
        srcCollection2.add(new Manul("manul2"));
        srcCollection2.add(new Manul("manul3"));
        srcCollection2.add(new Lynx("lynx1"));
        srcCollection2.add(new Lynx("lynx2"));
        srcCollection2.add(new Lynx("lynx3"));

        LinkedList<Chordates> collectionOfChordates = new LinkedList<>();
        LinkedList<Manul> collectionOfManuls = new LinkedList<>();
        LinkedList<Feline> collectionOfFeline2 = new LinkedList<>();
        segregate(srcCollection2, collectionOfChordates, collectionOfManuls, collectionOfFeline2);

        System.out.println(srcCollection2);
        System.out.println(collectionOfChordates);
        System.out.println(collectionOfManuls);
        System.out.println(collectionOfFeline2);

        LinkedList<Hedgehogs> srcCollection3 = new LinkedList<>();
        srcCollection3.add(new EuropeanHedgehog("hedgehog1"));
        srcCollection3.add(new EuropeanHedgehog("hedgehog2"));
        srcCollection3.add(new EuropeanHedgehog("hedgehog3"));

        LinkedList<Insectivores> collectionOfInsectivores = new LinkedList<>();
        LinkedList<Feline> collectionOfFeline3 = new LinkedList<>();
        LinkedList<Feline> collectionOfFeline4 = new LinkedList<>();
        segregate(srcCollection2, collectionOfInsectivores, collectionOfFeline3, collectionOfFeline4);

        System.out.println(srcCollection3);
        System.out.println(collectionOfChordates);
        System.out.println(collectionOfManuls);
        System.out.println(collectionOfFeline2);
    }

    public static void segregate(LinkedList<? extends Chordates> srcCollection,
                     LinkedList<? super EuropeanHedgehog >collection1,
                     LinkedList<? super Manul > collection2,
                     LinkedList<? super Lynx >collection3)
    {
       for(Chordates animal: srcCollection){
           if(animal instanceof EuropeanHedgehog){
               collection1.add((EuropeanHedgehog) animal);
           }
           if(animal instanceof Manul){
               collection2.add((Manul) animal);
           }
           if(animal instanceof Lynx){
               collection3.add((Lynx) animal);
           }
       }
    }
}
