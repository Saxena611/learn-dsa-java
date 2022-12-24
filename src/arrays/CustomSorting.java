package arrays;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSorting {

    public static void main(String[] args) {
        List<Name> nameArrayList =
                List.of(new Name("Animesh", "Saxena"),
                        new Name("Jphn", "Kennedy"),
                        new Name("Ben", "Warrings"));
        String str = String.format("%-20s %-20s %-20s %-20s %-20s", "COLUMN1", "COLUMN2", "COLUMN3", "COLUMN4", "COLUMN5");
        System.out.println(str);
        CustomSorting customSorting = new CustomSorting();
        // Sorting array list using streams
        List<Name> sortedListOfNames = customSorting.sortListOfNameUsingStreams(nameArrayList);
        System.out.println(sortedListOfNames);
        //

        System.out.println(customSorting.sortListByLastName(nameArrayList));


    }

    private Comparator<Name> sortByLastName(){
        return Comparator.comparing(Name::getLname);
    }

    private List<Name> sortListOfNameUsingStreams(List<Name> nameArrayList) {
        return nameArrayList.stream().
                sorted(Comparator.comparing(Name::getLname).
                        thenComparing(Name::getLname)).collect(Collectors.toList());
    }

    private List<Name> sortListByLastName(List<Name> nameArrayList){
        return  nameArrayList.stream().sorted(sortByLastName()).collect(Collectors.toList());
    }
}

class Name {
    public String fname;
    public String lname;

    Name(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Name{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
