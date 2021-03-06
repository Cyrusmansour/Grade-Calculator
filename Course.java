import java.util.ArrayList;
import java.util.HashMap;
import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Course {

    public String courseName;
    public ArrayList<GradedUnit> grades; //how many midterms, assignments etc 
    public HashMap<Integer, String> gradingScheme;

    public Course(String name){
        courseName = name;
        grades = new ArrayList<GradedUnit>(); 
        gradingScheme = new HashMap<Integer, String>();
        gradingScheme.put(85, "A");
        gradingScheme.put(80, "A-");
        gradingScheme.put(75, "B+");
        gradingScheme.put(70, "B");
        gradingScheme.put(65, "B-");
        gradingScheme.put(60, "C+");
        gradingScheme.put(55, "C");
    }

    public void calculateGrades() {
        float totalGrades, weightOfFinal, gradeNeeded;
        String letter, vowel;
        totalGrades = getTotalGrades();
        weightOfFinal = getWeight();

        //sort HashMap by keys first 
        //create a TreeMap with mappings of HashMap
        //TreeMap keeps all entries in sorted order
        TreeMap<Integer, String> sorted = new TreeMap<>(gradingScheme);
        Set<Entry<Integer, String>> mappings = sorted.entrySet();
        
        for(Entry<Integer, String> mapping : mappings) {
            gradeNeeded = (mapping.getKey() - totalGrades) / weightOfFinal;
            letter = gradingScheme.get(mapping.getKey());

            if(letter.charAt(0) == 'A') vowel = "an ";
            else vowel = "a ";
            System.out.println("Minimum grade on the final you need to get " + vowel + mapping.getValue() + " is " + gradeNeeded + "%.");
        }
    }

    private float getWeight() {
        float weight = 100;
        for(GradedUnit currentUnit : grades) {
            weight -= currentUnit.weight;
        }
        System.out.println("Weight of Final: " + weight/100);
        return weight / 100;
    }

    private float getTotalGrades() {
        float sum = 0;
        for(GradedUnit currentUnit : grades) {
            sum += currentUnit.gradeReceived * (currentUnit.weight/100);
        }
        System.out.println("Totalgrade so far: " + sum);
        return sum;
    }

    public void addGrade(float weight, float gradeReceived, String type) {
        GradedUnit newGradeUnit = new GradedUnit(weight, gradeReceived, type);    
        grades.add(newGradeUnit);
    }
}