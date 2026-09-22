import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class JavaModulesExplorer extends JFrame {

    private JTextArea outputArea;

    public JavaModulesExplorer() {
        setTitle("Java Modules Explorer");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Intro dialog on startup
		JTextArea introText = new JTextArea(
		    "Final MCO for ITE4 (Computer Programming 2)\n" +
		    "by: Yvone Garcia Brace\n" +
		    "BSCS-1C"
		);
		introText.setFont(new Font("Serif", Font.BOLD, 16));
		introText.setEditable(false);
		introText.setBackground(null);
		introText.setBorder(null);
		JOptionPane.showMessageDialog(this, introText, "Welcome", JOptionPane.INFORMATION_MESSAGE);


        // Text area for output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        // MODULE 1 Menu
        JMenu module1 = new JMenu("Module 1 - Arrays & Strings");
        module1.add(createMenuItem("Weather"));
        module1.add(createMenuItem("Password1"));
        module1.add(createMenuItem("Arr2Display"));
        module1.add(createMenuItem("ArrLargest"));
        module1.add(createMenuItem("ArrLowest"));
        module1.add(createMenuItem("Sorting"));
        module1.add(createMenuItem("AveReverse"));
        module1.add(createMenuItem("String1"));
        module1.add(createMenuItem("TallyString"));
        module1.add(createMenuItem("TallyNumber"));
        module1.add(createMenuItem("Object1"));
        module1.add(createMenuItem("Object2"));
        module1.add(createMenuItem("Object4"));
        module1.add(createMenuItem("BookObj"));

        // MODULE 2 Menu
        JMenu module2 = new JMenu("Module 2 - Data Structures");
        module2.add(createMenuItem("LinkedList"));
        module2.add(createMenuItem("Stack"));
        module2.add(createMenuItem("Queue"));
        module2.add(createMenuItem("Encap1"));

        // MODULE 3 Menu
        JMenu module3 = new JMenu("Module 3 - OOP Concepts");
        module3.add(createMenuItem("Inheritance"));
        module3.add(createMenuItem("Polymorphism"));

        menuBar.add(module1);
        menuBar.add(module2);
        menuBar.add(module3);

        setJMenuBar(menuBar);
        add(scrollPane);
    }

    private JMenuItem createMenuItem(String name) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(e -> runModule(name));
        return item;
    }

    private void runModule(String moduleName) {
        outputArea.setText(""); // Clear output
        switch (moduleName) {
            case "Weather":
                runWeather();
                break;
            case "Password1":
                runPassword1();
                break;
            case "Arr2Display":
                runArr2Display();
                break;
            case "ArrLargest":
                runArrLargest();
                break;
            case "ArrLowest":
                runArrLowest();
                break;
            case "Sorting":
                runSorting();
                break;
            case "AveReverse":
                runAveReverse();
                break;
            case "String1":
                runString1();
                break;
            case "TallyString":
                runTallyString();
                break;
            case "TallyNumber":
                runTallyNumber();
                break;
            case "Object1":
                runObject1();
                break;
            case "Object2":
                runObject2();
                break;
            case "Object4":
                runObject4();
                break;
            case "BookObj":
                runBookObj();
                break;
            case "LinkedList":
                runLinkedList();
                break;
            case "Stack":
                runStack();
                break;
            case "Queue":
                runQueue();
                break;
            case "Encap1":
                runEncap1();
                break;
            case "Inheritance":
                runInheritance();
                break;
            case "Polymorphism":
                runPolymorphism();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Module not implemented yet.");
        }
    }

    // ----- MODULE 1 implementations -----

    private void runWeather() {
        String input = JOptionPane.showInputDialog(this, "How many days' temperature?");
        if (input == null) return;
        int days;
        try {
            days = Integer.parseInt(input);
        } catch (Exception e) {
            showError("Invalid number");
            return;
        }

        int[] temps = new int[days];
        int sum = 0;

        for (int i = 0; i < days; i++) {
            String dayTempStr = JOptionPane.showInputDialog(this, "Day " + (i + 1) + "'s high temp:");
            if (dayTempStr == null) return;
            try {
                temps[i] = Integer.parseInt(dayTempStr);
            } catch (Exception e) {
                showError("Invalid temperature");
                return;
            }
            sum += temps[i];
        }

        double average = (double) sum / days;
        int count = 0;
        for (int t : temps) {
            if (t > average) count++;
        }

        outputArea.append(String.format("Average temp = %.2f\n", average));
        outputArea.append(count + " days above average\n");
    }

    private void runPassword1() {
        String accountName = JOptionPane.showInputDialog(this, "Account Name:");
        if (accountName == null) return;
        String password = JOptionPane.showInputDialog(this, "Password:");
        if (password == null) return;

        String[] credentials = {"Computer", "Science"};
        if (accountName.equals(credentials[0]) && password.equals(credentials[1])) {
            outputArea.append("Welcome to Java computer programming!\n");
        } else {
            outputArea.append("Wrong Entry!\n");
        }

        String S1 = "Computer";
        String S2 = "Science";

        outputArea.append("Length of S1: " + S1.length() + "\n");
        outputArea.append("Length of S2: " + S2.length() + "\n");
        outputArea.append("Concatenated String: " + S1.concat(S2) + "\n");
        outputArea.append("S1 equals S2: " + S1.equals(S2) + "\n");
        outputArea.append("S1 equals S2 (ignore case): " + S1.equalsIgnoreCase(S2) + "\n");
        outputArea.append("S2 contains 'e': " + S2.contains("e") + "\n");
        outputArea.append("Substring of S1 (1,5): " + S1.substring(1, 5) + "\n");
        outputArea.append("S1 replace 'o' with 'u': " + S1.replace('o', 'u') + "\n");
    }

    private void runArr2Display() {
        String course = "CS101 Introduction to Java Programming!";
        String[] students = {"Student 1", "Student 2", "Student 3", "Student 4",
                "Student 5", "Student 6", "Student 7", "Student 8",
                "Student 9", "Student 10"};
        int[][] grades = {
                {87, 96, 70}, {68, 87, 90}, {94, 100, 90}, {100, 81, 82},
                {83, 65, 85}, {78, 87, 65}, {85, 75, 83}, {91, 94, 100},
                {76, 72, 84}, {87, 93, 73}
        };

        outputArea.append("The grades are:\n");
        outputArea.append(course + "\n");
        outputArea.append(String.format("%-15s%-10s%-10s%-10s%-10s%n", "Student", "Test1", "Test 2", "Test 3", "Average"));

        for (int i = 0; i < students.length; i++) {
            double sum = 0;
            outputArea.append(String.format("%-15s", students[i]));
            for (int j = 0; j < 3; j++) {
                outputArea.append(String.format("%-10d", grades[i][j]));
                sum += grades[i][j];
            }
            double average = sum / 3.0;
            outputArea.append(String.format("%.2f%n", average)); // Print the average of the three tests
        }
    }

    private void runArrLargest() {
        int[] values = {32, 27, 64, 18, 95, 4, 90, 70, 40, 37};
        int max = values[0];
        for (int v : values) {
            if (v > max) max = v;
        }
        outputArea.append("The largest number in the array is: " + max + "\n");
    }

    private void runArrLowest() {
        int[] values = {32, 27, 64, 18, 95, 4, 90, 70, 40, 37};
        int min = values[0];
        for (int v : values) {
            if (v < min) min = v;
        }
        outputArea.append("The lowest number in the array is: " + min + "\n");
    }

    private void runSorting() {
        int[] values = {32, 27, 64, 18, 95, 4, 90, 70, 40, 37};
        Arrays.sort(values);
        outputArea.append("Sorted array:\n");
        for (int v : values) {
            outputArea.append(v + " ");
        }
        outputArea.append("\n");
    }

    private void runAveReverse() {
        int[] values = {32, 27, 64, 18, 95};
        int sum = 0;
        for (int v : values) sum += v;
        double avg = (double) sum / values.length;
        outputArea.append("Average: " + avg + "\n");
        outputArea.append("Reversed array:\n");
        for (int i = values.length - 1; i >= 0; i--) {
            outputArea.append(values[i] + " ");
        }
        outputArea.append("\n");
    }

    private void runString1() {
        String s = "Hello Java!";
        outputArea.append("String: " + s + "\n");
        outputArea.append("Length: " + s.length() + "\n");
        outputArea.append("Uppercase: " + s.toUpperCase() + "\n");
        outputArea.append("Lowercase: " + s.toLowerCase() + "\n");
        outputArea.append("Char at 1: " + s.charAt(1) + "\n");
        outputArea.append("Substring(6,10): " + s.substring(6, 10) + "\n");
    }

    private void runTallyString() {
        String input = JOptionPane.showInputDialog(this, "Enter a string:");
        if (input == null) return;

        int vowels = 0, consonants = 0;
        input = input.toLowerCase();

        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) >= 0) vowels++;
                else consonants++;
            }
        }
        outputArea.append("Vowels: " + vowels + "\n");
        outputArea.append("Consonants: " + consonants + "\n");
    }

    private void runTallyNumber() {
        String input = JOptionPane.showInputDialog(this, "Enter a string:");
        if (input == null) return;

        int digits = 0, letters = 0, others = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) digits++;
            else if (Character.isLetter(c)) letters++;
            else others++;
        }
        outputArea.append("Digits: " + digits + "\n");
        outputArea.append("Letters: " + letters + "\n");
        outputArea.append("Others: " + others + "\n");
    }

    // Replace runObject1()
	private void runObject1() {
	    // Area class (nested for this method)
	    class Area {
	        private double length;
	        private double breadth;

	        public void setDim(double length, double breadth) {
	            this.length = length;
	            this.breadth = breadth;
	        }

	        public double getArea() {
	            return length * breadth;
	        }
	    }

	    String lengthStr = JOptionPane.showInputDialog(this, "Enter length:");
	    if (lengthStr == null) return;
	    String breadthStr = JOptionPane.showInputDialog(this, "Enter breadth:");
	    if (breadthStr == null) return;

	    try {
	        double length = Double.parseDouble(lengthStr);
	        double breadth = Double.parseDouble(breadthStr);

	        Area rect = new Area();
	        rect.setDim(length, breadth);

	        outputArea.append("Area of rectangle: " + rect.getArea() + "\n");
	    } catch (NumberFormatException e) {
	        showError("Invalid input for length or breadth");
	    }
	}

	// Replace runObject2()
	private void runObject2() {
	    class Student {
	        String name;
	        int roll_no;
	    }

	    Student s = new Student();
	    s.name = "John";
	    s.roll_no = 2;

	    outputArea.append("Name is " + s.name + " and roll number is " + s.roll_no + "\n");
	}

	// Replace runObject4()
	private void runObject4() {
	    class Triangle {
	        int a = 3, b = 4, c = 5;

	        public double getArea() {
	            double s = (a + b + c) / 2.0;
	            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	        }

	        public int getPerimeter() {
	            return a + b + c;
	        }
	    }

	    Triangle t = new Triangle();

	    outputArea.append("Area of the triangle: " + t.getArea() + "\n");
	    outputArea.append("Perimeter of the triangle: " + t.getPerimeter() + "\n");
	}

	// Replace runBookObj()
	private void runBookObj() {
	    class Book {
	        String title;
	        String author;
	        int totalPages;
	        int yearPublished;

	        public Book(String title, String author, int totalPages, int yearPublished) {
	            this.title = title;
	            this.author = author;
	            this.totalPages = totalPages;
	            this.yearPublished = yearPublished;
	        }

	        public void display() {
	            outputArea.append("Title: " + title + "\n");
	            outputArea.append("Author: " + author + "\n");
	            outputArea.append("Total Pages: " + totalPages + "\n");
	            outputArea.append("Year Published: " + yearPublished + "\n\n");
	        }
	    }

	    Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 281, 1960);
	    Book book2 = new Book("1984", "George Orwell", 328, 1949);

	    outputArea.append("Book 1:\n");
	    book1.display();

	    outputArea.append("Book 2:\n");
	    book2.display();
	}


    // ----- MODULE 2 implementations -----

    private void runLinkedList() {
	    // We'll simulate the LinkedList example and print to outputArea

	    class Node {
	        int data;
	        Node next;
	    }

	    class LinkedList2 {
	        Node head;

	        public void insert(int data) {
	            Node newNode = new Node();
	            newNode.data = data;
	            newNode.next = null;

	            if (head == null) {
	                head = newNode;
	            } else {
	                Node temp = head;
	                while (temp.next != null)
	                    temp = temp.next;
	                temp.next = newNode;
	            }
	        }

	        public void display() {
	            Node temp = head;
	            StringBuilder sb = new StringBuilder();
	            while (temp != null) {
	                sb.append(temp.data).append(" -> ");
	                temp = temp.next;
	            }
	            sb.append("NULL\n");
	            outputArea.append(sb.toString());
	        }
	    }

	    LinkedList2 list = new LinkedList2();
	    list.insert(10);
	    list.insert(20);
	    list.insert(30);
	    list.display();
	}


    private void runStack() {
	    class Stack {
	        int[] stack = new int[5];
	        int top = -1;

	        public void push(int data) {
	            if (top < 4) {
	                top++;
	                stack[top] = data;
	            } else {
	                outputArea.append("Stack Overflow\n");
	            }
	        }

	        public void pop() {
	            if (top >= 0) {
	                outputArea.append("Popped: " + stack[top] + "\n");
	                top--;
	            } else {
	                outputArea.append("Stack Underflow\n");
	            }
	        }

	        public void display() {
	            outputArea.append("Stack: ");
	            for (int i = 0; i <= top; i++)
	                outputArea.append(stack[i] + " ");
	            outputArea.append("\n");
	        }
	    }

	    Stack s = new Stack();
	    s.push(10);
	    s.push(20);
	    s.push(30);
	    s.display();
	    s.pop();
	    s.display();
	}


    private void runQueue() {
	    class Queue {
	        int[] queue = new int[5];
	        int front = 0, rear = 0;

	        public void enqueue(int data) {
	            if (rear < 5) {
	                queue[rear] = data;
	                rear++;
	            } else {
	                outputArea.append("Queue Overflow\n");
	            }
	        }

	        public void dequeue() {
	            if (front < rear) {
	                outputArea.append("Dequeued: " + queue[front] + "\n");
	                front++;
	            } else {
	                outputArea.append("Queue Underflow\n");
	            }
	        }

	        public void display() {
	            outputArea.append("Queue: ");
	            for (int i = front; i < rear; i++)
	                outputArea.append(queue[i] + " ");
	            outputArea.append("\n");
	        }
	    }

	    Queue q = new Queue();
	    q.enqueue(100);
	    q.enqueue(200);
	    q.enqueue(300);
	    q.display();
	    q.dequeue();
	    q.display();
	}

    private void runEncap1() {
	    class Employee {
	        private String name;
	        private int age;
	        private int empID;

	        public void setName(String name) { this.name = name; }
	        public void setAge(int age) { this.age = age; }
	        public void setEmpID(int empID) { this.empID = empID; }

	        public String getName() { return name; }
	        public int getAge() { return age; }
	        public int getEmpID() { return empID; }
	    }

	    Employee e = new Employee();
	    e.setName("Richard");
	    e.setAge(41);
	    e.setEmpID(12465789);

	    outputArea.append("Employee's name: " + e.getName() + "\n");
	    outputArea.append("Employee's age: " + e.getAge() + "\n");
	    outputArea.append("Employee's ID: " + e.getEmpID() + "\n");
	}


    // ----- MODULE 3 implementations -----

    private void runInheritance() {
	    outputArea.setText("");  // Clear output area

	    class Animal {
	        void makeSound() {
	            outputArea.append("This animal makes a sound.\n");
	        }
	        void sleep() {
	            outputArea.append("This animal sleeps.\n");
	        }
	    }

	    class Tiger extends Animal {
	        String name = "Bengal Tiger";
	        void roar() {
	            outputArea.append(name + " roars loudly!\n");
	        }
	        void hunt() {
	            outputArea.append(name + " is hunting in the jungle.\n");
	        }
	    }

	    Tiger myTiger = new Tiger();

	    myTiger.makeSound(); // inherited from Animal
	    myTiger.sleep();     // inherited from Animal
	    myTiger.roar();      // from Tiger
	    myTiger.hunt();      // from Tiger
	}

	private void runPolymorphism() {
	    outputArea.setText("");  // Clear output area

	    class Animal {
	        void sound() {
	            outputArea.append("This animal makes a sound\n");
	        }
	    }

	    class Dog extends Animal {
	        @Override
	        void sound() {
	            outputArea.append("The dog barks\n");
	        }
	    }

	    class Cat extends Animal {
	        @Override
	        void sound() {
	            outputArea.append("The cat meows\n");
	        }
	    }

	    Animal a;

	    a = new Dog();
	    a.sound();  // Output: The dog barks

	    a = new Cat();
	    a.sound();  // Output: The cat meows
	}


    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JavaModulesExplorer frame = new JavaModulesExplorer();
            frame.setVisible(true);
        });
    }
}