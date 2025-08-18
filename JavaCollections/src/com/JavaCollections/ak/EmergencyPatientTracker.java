package com.JavaCollections.ak;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EmergencyPatientTracker {

    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(new PatientComparator());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patients (type 'END' to stop). Lower severity number means more severe.");

        while (true) {
            System.out.print("Patient name: ");
            String name = scanner.next();
            if (name.equalsIgnoreCase("END")) {
                break;
            }

            System.out.print("Severity (integer): ");
            int severity = scanner.nextInt();

            queue.add(new Patient(name, severity, LocalDateTime.now()));
        }

        scanner.close();

        System.out.println("Patients in priority order:");
        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.getName() + " (severity: " + p.getSeverity() + ", time: " + p.getTimestamp() + ")");
        }
    }
}

class Patient {
    String name;
    int severity;
    LocalDateTime timestamp;

    public Patient(String n, int s, LocalDateTime t) {
        name = n;
        severity = s;
        timestamp = t;
    }

    public String getName() { return name; }
    public int getSeverity() { return severity; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

class PatientComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        int diff = Integer.compare(p1.severity, p2.severity);
        if (diff != 0) return diff;
        return p1.timestamp.compareTo(p2.timestamp);
    }
}
