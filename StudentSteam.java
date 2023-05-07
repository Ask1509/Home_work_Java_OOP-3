import java.util.ArrayList;

import java.util.Collections;

import java.util.Iterator;

import java.util.List;



class StudentStream implements Iterable<StudentGroup> {



    private int streamNumber;

    private List<StudentGroup> groups;



    public StudentStream(int streamNumber) {

        this.streamNumber = streamNumber;

        this.groups = new ArrayList<>();

    }



    public void addGroup(StudentGroup group) {

        this.groups.add(group);

    }



    public int getStreamNumber() {

        return streamNumber;

    }



    public List<StudentGroup> getGroups() {

        return groups;

    }



    public Iterator<StudentGroup> iterator() {

        return groups.iterator();

    }



}



class StudentGroup implements Comparable<StudentGroup> {



    private String name;

    private int numberOfStudents;



    public StudentGroup(String name, int numberOfStudents) {

        this.name = name;

        this.numberOfStudents = numberOfStudents;

    }



    public String getName() {

        return name;

    }



    public int getNumberOfStudents() {

        return numberOfStudents;

    }



    public int compareTo(StudentGroup otherGroup) {

        return Integer.compare(this.numberOfStudents, otherGroup.numberOfStudents);

    }



    public String toString() {

        return "Group " + name + " (" + numberOfStudents + " students)";

    }



}



public class Main {



    public static void main(String[] args) {

        StudentStream stream = new StudentStream(1);



        StudentGroup group1 = new StudentGroup("Group 1", 20);

        StudentGroup group2 = new StudentGroup("Group 2", 15);

        StudentGroup group3 = new StudentGroup("Group 3", 10);



        stream.addGroup(group1);

        stream.addGroup(group2);

        stream.addGroup(group3);



        for (StudentGroup group : stream) {

            System.out.println(group);

        }



        Collections.sort(stream.getGroups());



        for (StudentGroup group : stream) {

            System.out.println(group);

        }

    }



}