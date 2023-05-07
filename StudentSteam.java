import java.util.ArrayList;

import java.util.Collections;

import java.util.Iterator;

import java.util.List;

/*
 * представляет поток студентов и содержит поле`streamNumber` - номер потока, 
 * и список `groups` - список учебных групп,представленных объектами класса `StudentGroup`.
 * 
 */

class StudentStream implements Iterable<StudentGroup> {



    private int streamNumber;

    private List<StudentGroup> groups;



    public StudentStream(int streamNumber) {

        this.streamNumber = streamNumber;

        this.groups = new ArrayList<>();

    }

/*
 * Метод `addGroup(StudentGroup group)` добавляет группу в список групп потока.
 */

    public void addGroup(StudentGroup group) {

        this.groups.add(group);

    }

/*
 * Метод `getStreamNumber()` возвращает номер потока, а метод `getGroups()`
 * возвращает список групп.
 */

    public int getStreamNumber() {

        return streamNumber;

    }



    public List<StudentGroup> getGroups() {

        return groups;

    }

/*
 * Интерфейс `Iterable` был реализован, поэтому в классе `StudentStream` былреализован метод `iterator()`, 
 * который возвращает итератор для списка групп.
 */

    public Iterator<StudentGroup> iterator() {

        return groups.iterator();

    }



}

/*
 * Класс `StudentGroup` представляет учебную группу и содержит поля `name` -название группы, 
 * и `numberOfStudents` - количество студентов в группе.
 */

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

/*
 * Метод `compareTo(StudentGroup otherGroup)` реализует метод 
 * сравненияобъектов класса `StudentGroup` по количеству студентов.
 */
    public int compareTo(StudentGroup otherGroup) {

        return Integer.compare(this.numberOfStudents, otherGroup.numberOfStudents);

    }

/*
 * Метод `toString()` возвращает строку с названием группы и количеством студентов.
 */

    public String toString() {

        return "Group " + name + " (" + numberOfStudents + " students)";

    }


}

/*
 * В методе `main` создается объект `stream` класса `StudentStream` с номеромпотока 1. 
 * Затем создаются три объекта `group1`, `group2`, `group3` класса`StudentGroup` с разным количеством студентов, 
 * и каждая группа добавляется всписок групп потока.
 */

public class Main {



    public static void main(String[] args) {

        StudentStream stream = new StudentStream(1);



        StudentGroup group1 = new StudentGroup("Group 1", 20);

        StudentGroup group2 = new StudentGroup("Group 2", 15);

        StudentGroup group3 = new StudentGroup("Group 3", 10);


        stream.addGroup(group1);

        stream.addGroup(group2);

        stream.addGroup(group3);
/*
 * Цикл `for` используется для вывода списка групп на консоль, 
 * а после этогосписок сортируется методом `sort` класса `Collections`, используя интерфейс`Comparable`.
 */

        for (StudentGroup group : stream) {

            System.out.println(group);

        }

        Collections.sort(stream.getGroups());

        for (StudentGroup group : stream) {

            System.out.println(group);

        }

    }

/*
 * После сортировки группы выводятся на консоль в отсортированном порядке.
 */

}