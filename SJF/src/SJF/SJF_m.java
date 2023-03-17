/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SJF;
import java.util.*;

public class SJF_m {

public static void main(String[] args) {

    //______________________________________________________________________
    //input
    //______________________________________________________________________
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter NO of processes");
    int n = sc.nextInt();
    int ID;
    int ArrivalTime[] = new int[n];
    int ServiceTime[] = new int[n];
    int FinishTime[] = new int[n];
    int StartTime[] = new int[n];
    int WaitingTime[] = new int[n];
    int TurnAroundTime [] = new int[n];
    int TotalWaitingTime = 0;
    int TotalTurnAroundTime = 0;
    double AVGWaitingTime;
    double AVGTurnAroundTime;


    System.out.println("_____________________________________");

    for (int i = 0; i < n; i++) {
        System.out.println("Enter id of process  " + (i + 1));
        ID = sc.nextInt();
    }

    System.out.println("______________________________________");

    System.out.println("*Enter arrival time for each process*");
    for (int i = 0; i < n; i++) {
        System.out.println("Enter arival time for process  " + (i + 1));
        ArrivalTime[i] = sc.nextInt();
    }

    System.out.println("_______________________________________");

    System.out.println("*Enter service time for each process*");
    for (int i = 0; i < n; i++) {
        System.out.println("Enter service time for process  " + (i + 1));
        ServiceTime[i] = sc.nextInt();
    }

    //______________________________________________________________________
    //process
    //______________________________________________________________________
    int time = 0; // "time" for the current time.
    int min = 0;  // "min" for the least service time.
    int j = 0;    // "j" to save the task with the least time.
    int count;    // "count" to identify if it is the first operation in this turn. 

    for (int c = 0; c < n; c++) {
        count = 0;
        for (int i = 0; i < n; i++) //looping through all the tasks
        {
            if (FinishTime[i] == 0) //checking if the task wasn't done before
            {
                if (ArrivalTime[i] <= time) //checking if the task arrived or not
                {
                    count++;
                    if (count == 1) //checking if it's the first task in this turn
                    {
                        min = ServiceTime[i];
                        j = i;
                    } else {
                        if (ServiceTime[i] < min) //checking if the task's service time is less than the current min
                        {
                            min = ServiceTime[i];
                            j = i; //takes procees number and puts it in "j" then compares again
                        }
                    }
                }
            }
        }
        StartTime[j] = time;
        time += min;
        FinishTime[j] = time;
    }

    //calculating waiting time and turn around time
    for (int y = 0; y < n; y++) {
        WaitingTime[y] = StartTime[y] - ArrivalTime[y];
        TurnAroundTime[y] = WaitingTime[y] + ServiceTime[y];
        TotalWaitingTime += WaitingTime[y];
        TotalTurnAroundTime += TurnAroundTime[y];
    }

    AVGWaitingTime = (double) TotalWaitingTime / n;
    AVGTurnAroundTime = (double) TotalTurnAroundTime / n;

    //______________________________________________________________________
    //output
    //______________________________________________________________________
    System.out.println("*Finish time for the processes*");

    System.out.println("_______________________________________");

    for (int i = 0; i < n; i++) {
        System.out.println("Finish time for process  " + (i + 1) + "  " + FinishTime[i]);
    }

    System.out.println("____________________________________________________");

    System.out.println("*Waiting time time for the processes*");

    System.out.println("_______________________________________");

    for (int i = 0; i < n; i++) {
        System.out.println("Waiting time for process  " + (i + 1) + "  " + WaitingTime[i]);
    }

    System.out.println("____________________________________________________");

    for (int i = 0; i < n; i++) {
        System.out.println("Turnaround time time for process  " + (i + 1) + "  " + TurnAroundTime[i]);
    }

    System.out.println("____________________________________________________");

    System.out.println("_______________________________________");

    System.out.println("AVGWaiting time for processes  " + "  " + AVGWaitingTime);

    System.out.println("____________________________________________________");

    System.out.println("AVGTurnAroundTime time for processes  " + "  " + AVGTurnAroundTime);

    System.out.println("____________________________________________________");

 }
}