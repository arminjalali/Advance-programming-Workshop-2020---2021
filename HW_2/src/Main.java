public class Main {

    public static void main(String[] args) {
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");
        Student std4 = new Student("Armin", "Jalali", "9831019");
        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFirstName("HamidReza");
        std3.print();

        std4.print();
        std4.setGrade(19);
        std4.print();
        System.out.println("\n\n\n");
        Lab lab = new Lab(3, "wednesday");
        Lab lab2 = new Lab(2,"sunday");
        Student[] students = new Student[4];
        Student[] students1 = new Student[1];

        lab.setStudents(students);
        lab.enrollStudent(std1);
        lab.enrollStudent(std2);
        lab.enrollStudent(std3);
        lab.calculateAvg();
        lab.print();

        lab2.setStudents(students1);
        lab2.enrollStudent(std4);
        lab2.calculateAvg();
        lab2.print();

        System.out.println("\n\n\n");
        Lab[] labs = new Lab[2];
        College college = new College("CE");
        college.setLabs(labs);

        college.addLab(lab);
        college.addLab(lab2);
        college.calculateAvg();
        college.print();
    }
}
