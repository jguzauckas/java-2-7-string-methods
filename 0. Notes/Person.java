public class Person {
    private int age;
    private String firstName;
    private String lastName;

    public Person(){
        age = 0;
        firstName = "";
        lastName = "";
    }

    public Person(int a){
        age = a;
        firstName = "";
        lastName = "";
    }

    public Person(int a, String f, String l){
        age = a;
        firstName = f;
        lastName = l;
    }

    public String toString(){
        return age + " years old";
    }

    public int getAge(){
        return age;
    }

    public void setAge(int a){
        age = a;
    }

    public int numYearsUntil(int y){
        return y - age;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String f){
        firstName = f;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String l){
        lastName = l;
    }
}