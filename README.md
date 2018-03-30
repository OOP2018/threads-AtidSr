## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |     10,000,000     |  0.021205       |
| Using ReentrantLock     |      1,000,000     |  0.391034       |
| Syncronized method      |      1,000,000     |  0.344338       |
| AtomicLong for total    |      1,000,000     |  0.158323       |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

1.1 , 1.3) <br />
It should be zero but it not always zero.
It use same counter and it run at same time( parallel run) example Thread1 run same Time as Thread2 (Thread1 run add Thread2 run subtract at same time) if Thread1 finish first counter's value will be overwrite by Thread2 counter's value <br />
1.2 ) <br />
Count 1 to 10,000,000 in 0.019735 sec
Counter total is -44951866575256
<br />
Count 1 to 10,000,000 in 0.022628 sec
Counter total is -49989634064785
<br />
Count 1 to 10,000,000 in 0.021252 sec
Counter total is -49987365023869
## 2. Implications for Multi-threaded Applications

How might this affect real applications?  
<br />
Example: if withdraw using addTask and deposit using subtractTask. Then when withdraw and deposit at same time money in the bank will be minus value.

## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4 <br />
3.1) It always zero.  <br />

3.2) CounterwithLock not allow thread run at same time (if thread1 run thread2 is waiting.Thread2 will run when thread1 is finish) not like problem1 that thread run at the same time.
<br />
3.3) When counterWithLock is call ,ReentrantLock lock thread to prevent calling this counterWithLock until the first one is finish. ReentrantLock will unlock counterWithLock .
<br />
Why ? Because real data and data that program execute is inconsistency.
<br />
When ? When program is sharing data and have chance the data would be modified resulting in inconsistency.
<br />
3.4) Because finally is always execute when try block exits. To make sure that ReentrantLock is unlock.

## 4. Counter with synchronized method

answer question 4 <br />
4.1)  It always zero. 
<br />
4.2) synchronized not allow thread run at same time (if thread1 run thread2 is waiting.Thread2 will run when thread1 is finish) not like problem1 that thread run at the same time.
<br />

4.3) Synchronized meaning is cause to occur or operate at the same time.
<br />

Why ? Because real data and data that program execute is inconsistency.
<br />

When ? When program is sharing data and have chance the data would be modified resulting in inconsistency.
 
## 5. Counter with AtomicLong

answer question 5

## 6. Analysis of Results

answer question 6

## 7. Using Many Threads (optional)

