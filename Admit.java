// Rhea Toves
// 2/2/2021
// TA: Jeremy Chen
// Assignment #4: Admit.java
//
// This program will generate an interactive program.
// This version includes if/else statements and methods
// that return values.

import java.util.*;

// generates the whole interactive program
public class Admit {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      double examScore1 = giveIntro1(console);
      double GPA1 = getGPA1(console);
      double examScore2 = giveIntro2(console);
      double GPA2 = getGPA2(console);
      double one = examScore1 + GPA1;
      double two = examScore2 + GPA2;
      overall(examScore1, examScore2, GPA1, GPA2);
      reportingStatus(one, two);
      
   }
   
   // computes SAT exam scores
   public static double getExam1(Scanner console) {
      System.out.print("    SAT math? ");
      double math1 = console.nextDouble();
      System.out.print("    SAT critical reading? ");
      double reading1 = console.nextDouble();
      System.out.print("    SAT writing? ");
      double writing1 = console.nextDouble();
      double SAT = SATFor(math1, reading1, writing1);
      System.out.print("    exam score = ");
      System.out.println(round1(SAT));
      return SAT;
      
   }
   
   // computes ACT exam scores
   public static double getExam2(Scanner console) {
      System.out.print("    ACT English? ");
      double english2 = console.nextDouble();
      System.out.print("    ACT math? ");
      double math2 = console.nextDouble();
      System.out.print("    ACT reading? ");
      double reading2 = console.nextDouble();
      System.out.print("    ACT science? ");
      double science2 = console.nextDouble();
      double ACT = ACTFor(english2, math2, reading2, science2);
      System.out.print("    exam score = ");
      System.out.println(round1(ACT));
      return ACT;
      
   }
   
   // SAT formula
   public static double SATFor(double math1, double reading1, double writing1) {
      return (((2 * math1) + reading1 + writing1) / 32);
      
   }
   
   // ACT formula
   public static double ACTFor(double english2, double math2, double reading2, double science2) {
      return ((english2 + (2* math2) + reading2 + science2) / 1.8);
      
   }
   
   // generates introduction and intro statements for applicant #1
   public static double giveIntro1(Scanner console) {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
      System.out.print("Information for applicant #1: ");
      System.out.println();
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      double answer1 = console.nextDouble();
      double examScore1 = examType1(console, answer1);
      return examScore1;
      
   }
   
   // generates introduction statements for applicant #2
   public static double giveIntro2(Scanner console) {
      System.out.println();
      System.out.print("Information for applicant #2: ");
      System.out.println();
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      double answer2 = console.nextDouble();
      double examScore2 = examType2(console, answer2);
      return examScore2;
      
   }
   
   // when the second applicant #1 inputs 1 or 2, this generates the correct caluclations
   public static double examType1(Scanner console, double answer1) {
      if (answer1 == 1) {
         return getExam1(console);
      } else {
         return getExam2(console);
      }
   }
   
   // when the second applicant #2 inputs 1 or 2, this generates the correct caluclations
   public static double examType2(Scanner console, double answer2) {
      if (answer2 == 1) {
         return getExam1(console);
      } else {
         return getExam2(console);
      }
   }
   
   // computes applicant #1 GPA score
   public static double getGPA1(Scanner console) {
      System.out.print("    overall GPA? ");
      double overall1 = console.nextDouble();
      System.out.print("    max GPA? ");
      double max1 = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier1 = console.nextDouble();
      double GPA1 = GPA1For(overall1, max1, multiplier1);
      System.out.print("    GPA score = ");
      System.out.println(round1(GPA1));
      return GPA1;
      
   }
   
   // computes applicant #2 GPA score
   public static double getGPA2(Scanner console) {
      System.out.print("    overall GPA? ");
      double overall2 = console.nextDouble();
      System.out.print("    max GPA? ");
      double max2 = console.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier2 = console.nextDouble();
      double GPA2 = GPA1For(overall2, max2, multiplier2);
      System.out.print("    GPA score = ");
      System.out.println(round1(GPA2));
      return GPA2;
      
   }
   
   // GPA formula for applicant #1
   public static double GPA1For(double overall1, double max1, double multiplier1) {
      return (((overall1 / max1) * 100) * multiplier1);
      
   }
   
   // GPA formula for applicant #2
   public static double GPA2For(double overall2, double max2, double multiplier2) {
      return (((overall2 / max2) * 100) * multiplier2);
      
   }
   
   // calculates the overall statements
   public static void overall(double examScore1, double examScore2, double GPA1, double GPA2) {
      System.out.println();
      double one = examScore1 + GPA1;
      System.out.println("First applicant overall score  = " + (round1(one)));
      double two = examScore2 + GPA2;
      System.out.println("Second applicant overall score = " + (round1(two)));
      
   }
   
   // declares which applicant was better
   public static void reportingStatus(double one, double two) {
      if (one > two) {
         System.out.println("The first applicant seems to be better");
      } else if (one < two) {
         System.out.println("The second applicant seems to be better");
      } else { // (one == two)
         System.out.println("The two applicants seem to be equal");
         
      }
   }
   
   // returns the result of rounding n to 1 digit after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}