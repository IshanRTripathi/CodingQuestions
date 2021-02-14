package main.java.generalUtility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AttendanceGenerator {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter start date in the format yyyy-MM-dd\nEnd date will be by default the most recent Friday");
        Scanner sc= new Scanner(System.in);

        LocalDate start = LocalDate.parse(sc.nextLine());

        LocalDate end = LocalDate.now();
        List<LocalDate> dates= Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                .collect(Collectors.toList());

        FileWriter fileWriter = new FileWriter("src/main/java/generalUtility/fileOutput.csv");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Date,Check-in at,Check-out at,Place,Compensation work day");

        StringBuilder result = new StringBuilder();
        for(LocalDate date: dates) {
            if(date.getDayOfWeek()== DayOfWeek.SATURDAY || date.getDayOfWeek()== DayOfWeek.SUNDAY)
                continue;
            result.append(date).append(",09:00:00,18:00:00,Work from home,NO\n");
        }
        printWriter.print(result.substring(0, result.length()-1));
        printWriter.close();
    }
}
