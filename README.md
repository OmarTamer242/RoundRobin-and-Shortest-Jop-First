# RoundRobin-and-Shortest-Jop-First
This project contains Java implementations of two CPU scheduling algorithms: RoundRobin (RR) and Shortest-Jop-First (SJF).

## RoundRobin
round-robin scheduler generally employs time-sharing, giving each job a time slot or quantum[5] (its allowance of CPU time), and interrupting the job if it is not completed by then. The job is resumed next time a time slot is assigned to that process. If the process terminates or changes its state to waiting during its attributed time quantum, the scheduler selects the first process in the ready queue to execute. In the absence of time-sharing, or if the quanta were large relative to the sizes of the jobs, a process that produced large jobs would be favored over other processes.
Round-robin algorithm is a pre-emptive algorithm as the scheduler forces the process out of the CPU once the time quota expires.
The implementation of the FCFS algorithm can be found in the <a href-"https://github.com/OmarTamer242/RoundRobin-and-Shortest-Jop-First/tree/main/RoundRobin">RoundRobin.java</a> file.
