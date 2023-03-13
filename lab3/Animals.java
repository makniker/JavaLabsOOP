package lab3;

import java.util.ArrayList;

public class Animals {
    public static void main(String[] args) {
        ArrayList<Mammals> SrcCollection1 = new ArrayList<>(9);
        SrcCollection1.add(new Manul("manul1"));
        SrcCollection1.add(new Manul("manul2"));
        SrcCollection1.add(new Manul("manul3"));
        SrcCollection1.add(new Lynx("lynx1"));
        SrcCollection1.add(new Lynx("lynx2"));
        SrcCollection1.add(new Lynx("lynx3"));
        SrcCollection1.add(new EuropeanHedgehog("hedgehog1"));
        SrcCollection1.add(new EuropeanHedgehog("hedgehog2"));
        SrcCollection1.add(new EuropeanHedgehog("hedgehog3"));

        ArrayList<Hedgehogs> CollectionOfHedgehogs = new ArrayList<>(3);
        ArrayList<Feline> CollectionOfFeline = new ArrayList<>(3);
        ArrayList<Predatory> CollectionOfPredators = new ArrayList<>(3);

        segregate(SrcCollection1, CollectionOfHedgehogs, CollectionOfFeline, CollectionOfPredators);

        System.out.println(SrcCollection1);
        System.out.println(CollectionOfFeline);
        System.out.println(CollectionOfHedgehogs);
        System.out.println(CollectionOfPredators);

        ArrayList<Predatory> SrcCollection2 = new ArrayList<>(9);
        SrcCollection2.add(new Manul("manul1"));
        SrcCollection2.add(new Manul("manul2"));
        SrcCollection2.add(new Manul("manul3"));
        SrcCollection2.add(new Lynx("lynx1"));
        SrcCollection2.add(new Lynx("lynx2"));
        SrcCollection2.add(new Lynx("lynx3"));

        ArrayList<Chordates> CollectionOfChordates = new ArrayList<>(3);
        ArrayList<Manul> CollectionOfManuls = new ArrayList<>(3);
        ArrayList<Feline> CollectionOfFeline2 = new ArrayList<>(3);
        segregate(SrcCollection2, CollectionOfChordates, CollectionOfManuls, CollectionOfFeline2);

        System.out.println(SrcCollection2);
        System.out.println(CollectionOfChordates);
        System.out.println(CollectionOfManuls);
        System.out.println(CollectionOfFeline2);

        ArrayList<Hedgehogs> SrcCollection3 = new ArrayList<>(9);
        SrcCollection3.add(new EuropeanHedgehog("hedgehog1"));
        SrcCollection3.add(new EuropeanHedgehog("hedgehog2"));
        SrcCollection3.add(new EuropeanHedgehog("hedgehog3"));

        ArrayList<Insectivores> CollectionOfInsectivores = new ArrayList<>(3);
        ArrayList<Feline> CollectionOfFeline3 = new ArrayList<>(3);
        ArrayList<Feline> CollectionOfFeline4 = new ArrayList<>(3);
        segregate(SrcCollection2, CollectionOfInsectivores, CollectionOfFeline3, CollectionOfFeline4);

        System.out.println(SrcCollection3);
        System.out.println(CollectionOfChordates);
        System.out.println(CollectionOfManuls);
        System.out.println(CollectionOfFeline2);
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
