package com.mycompany.actividad_13_cj;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author ALAN
 */
public class Main {
    List < String > strings =  new  ArrayList <> ();
    public static void main(String[] args) {
        
        Main lista = new Main();
        
        lista.loadStrings("Oscar","Platano","Pikachu", "Pulpo","Cacahuate","Rabano","Zapato","Cubo","Micky","Uva");
        
        var sortAlphabeticByAnonymousClass = lista.sortAlpabheticAnonymousClass();
        var sortAlphabeticByLamda = lista.sortAlpabheticLambaFunction();
        var sortAlphabeticByReference = lista.sortAlpabheticReference();
        var sortLenghtAnonymousClass = lista.sortLenghtAnonymousClass();
        var sortLenghtLambaFunction = lista.sortLenghtLambaFunction();
        var sortLenghtReference = lista.sortLenghtReference();
        
        System.out.println("Ordenado por longitud utilizando clase anónima");
        lista.showList(sortAlphabeticByAnonymousClass);
        System.out.println("\nOrdenado por longitud utilizando expresión lambda");
        lista.showList(sortAlphabeticByLamda);
        System.out.println("\nOrdenado por longitud utilizando método de referencia");
        lista.showList(sortAlphabeticByReference);
        System.out.println("\nOrdenado por orden alfabético utilizando clase anónima");
        lista.showList(sortLenghtAnonymousClass);
        System.out.println("\nOrdenado por orden alfabético utilizando expresión Lambda");
        lista.showList(sortLenghtLambaFunction);
        System.out.println("\nOrdenado por orden alfabético utilizando método de referencia");
        lista.showList(sortLenghtReference);
}
    
    public void loadStrings (String...strings){
        this.strings.addAll(Arrays.asList(strings));
    }
    public List<String>sortAlpabheticAnonymousClass(){
        List<String>strings=this.strings;
        strings.sort(String::compareToIgnoreCase);
        return strings;
    }
    public List<String>sortAlpabheticLambaFunction(){
        List<String>strings=this.strings;
        strings.sort(String::compareToIgnoreCase);
        return strings;
    }
    public List<String>sortAlpabheticReference(){
        List<String>strings=this.strings;
        SortAlphabetic sortAlphabetic=new SortAlphabetic();
        strings.sort(sortAlphabetic::compare);
          return strings;
            }
            public List<String>sortLenghtAnonymousClass(){
        List<String>strings=this.strings;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String objecto1, String objecto2) {
                return objecto1.length()-objecto2.length();
            }
        });
        return strings;
            }
    public List<String>sortLenghtLambaFunction(){
        List<String>strings=this.strings;
        strings.sort((objecto1, objecto2) -> objecto1.length()-objecto2.length());
        return strings;
    }
    public List<String>sortLenghtReference(){
        List<String>strings=this.strings;
        SortLenght sortLenght=new SortLenght();
        strings.sort(sortLenght::compare);
        return strings;
    }
    public void showList(List<String>list){
        list.forEach(System.out::println);
    }
}
class SortAlphabetic implements Comparator{
    public static int sort(Object a, Object b){
        return a.toString().compareToIgnoreCase(b.toString());
    }
    @Override
    public int compare(Object b, Object c){
        return b.toString().compareToIgnoreCase(c.toString());
    }
}
class  SortLenght implements Comparator{

    @Override
    public int compare(Object b, Object c) {
        return b.toString().length() - c.toString().length();
    }
}
