public class Person {
    private int age;
    private boolean isStudent;
    private double heightInches;
    private int birthYear;

    public Person(){
        age = 0;
        isStudent = false;
        heightInches = 10.0;
        birthYear = 1900;
    }

    public Person(int a){
        age = a;
        isStudent = false;
        heightInches = 10.0;
        birthYear = 1900;
    }

    public Person(int a, boolean s, double h, int b){
        age = a;
        isStudent = s;
        heightInches = h;
        birthYear = b;
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

    public boolean getIsStudent(){
        return isStudent;
    }

    public void setIsStudent(boolean s){
        isStudent = s;
    }

    public double getHeightInches(){
        return heightInches;
    }

    public void setHeightInches(double h){
        heightInches = h;
    }

    public double convertHeightFeet(){
        return heightInches / 12;
    }

    public double heightIfGrowthSpurt(double h){
        return heightInches + h;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public void setBirthYear(int b){
        birthYear = b;
    }
}