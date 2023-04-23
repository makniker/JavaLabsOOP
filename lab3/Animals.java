package lab3;

import java.util.ArrayList;

public class Animals {
    public static void main(String[] args) {
        ArrayList<Mammals> srcCollection1 = new ArrayList<>(9);
        srcCollection1.add(new Manul("manul1"));
        srcCollection1.add(new Manul("manul2"));
        srcCollection1.add(new Manul("manul3"));
        srcCollection1.add(new Lynx("lynx1"));
        srcCollection1.add(new Lynx("lynx2"));
        srcCollection1.add(new Lynx("lynx3"));
        srcCollection1.add(new EuropeanHedgehog("hedgehog1"));
        srcCollection1.add(new EuropeanHedgehog("hedgehog2"));
        srcCollection1.add(new EuropeanHedgehog("hedgehog3"));

        ArrayList<Hedgehogs> collectionOfHedgehogs = new ArrayList<>(3);
        ArrayList<Feline> collectionOfFeline = new ArrayList<>(3);
        ArrayList<Predatory> collectionOfPredators = new ArrayList<>(3);

        segregate(srcCollection1, collectionOfHedgehogs, collectionOfFeline, collectionOfPredators);

        System.out.println(srcCollection1);
        System.out.println(collectionOfFeline);
        System.out.println(collectionOfHedgehogs);
        System.out.println(collectionOfPredators);

        ArrayList<Predatory> srcCollection2 = new ArrayList<>(9);
        srcCollection2.add(new Manul("manul1"));
        srcCollection2.add(new Manul("manul2"));
        srcCollection2.add(new Manul("manul3"));
        srcCollection2.add(new Lynx("lynx1"));
        srcCollection2.add(new Lynx("lynx2"));
        srcCollection2.add(new Lynx("lynx3"));

        ArrayList<Chordates> collectionOfChordates = new ArrayList<>(3);
        ArrayList<Manul> collectionOfManuls = new ArrayList<>(3);
        ArrayList<Feline> collectionOfFeline2 = new ArrayList<>(3);
        segregate(srcCollection2, collectionOfChordates, collectionOfManuls, collectionOfFeline2);

        System.out.println(srcCollection2);
        System.out.println(collectionOfChordates);
        System.out.println(collectionOfManuls);
        System.out.println(collectionOfFeline2);

        ArrayList<Hedgehogs> srcCollection3 = new ArrayList<>(9);
        srcCollection3.add(new EuropeanHedgehog("hedgehog1"));
        srcCollection3.add(new EuropeanHedgehog("hedgehog2"));
        srcCollection3.add(new EuropeanHedgehog("hedgehog3"));

        ArrayList<Insectivores> collectionOfInsectivores = new ArrayList<>(3);
        ArrayList<Feline> collectionOfFeline3 = new ArrayList<>(3);
        ArrayList<Feline> collectionOfFeline4 = new ArrayList<>(3);
        segregate(srcCollection2, collectionOfInsectivores, collectionOfFeline3, collectionOfFeline4);

        System.out.println(srcCollection3);
        System.out.println(collectionOfChordates);
        System.out.println(collectionOfManuls);
        System.out.println(collectionOfFeline2);
    }

    public static void segregate(ArrayList<? extends Chordates> SrcCollection,
                     ArrayList<? super EuropeanHedgehog >Collection1,
                     ArrayList<? super Manul > Collection2,
                     ArrayList<? super Lynx >Collection3)
    {
       for(Chordates animal: SrcCollection){
           if(animal instanceof EuropeanHedgehog){
               Collection1.add((EuropeanHedgehog) animal);
           }
           if(animal instanceof Manul){
               Collection2.add((Manul) animal);
           }
           if(animal instanceof Lynx){
               Collection3.add((Lynx) animal);
           }
       }
    }
}
