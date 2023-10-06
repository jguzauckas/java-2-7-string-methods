public class NotesCompareTo1 {
    public static void main(String[] args){
        String string1 = "Hi";
        String string2 = "Hello";
        String string3 = "Hello";

        System.out.println(string1.compareTo(string2));
        System.out.println(string2.compareTo(string1));
        System.out.println(string1.compareTo(string3));
        System.out.println(string3.compareTo(string1));
        System.out.println(string2.compareTo(string3));
        System.out.println(string3.compareTo(string2));
    }
}
