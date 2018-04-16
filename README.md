# INFO6205-515
Akshay Gavandi and Vignesh Raghuraman

Problem Statement and Approach

To develop the genetic algorithm for solving the ball out of a box problem. The main objective is to come out of the box. To acheive this, the ball can move around, alter its size and reproduce so that if not the original population, atleast its generations might come out of the box. The balls might get extinct depending on their size or if they show no traits of improvement to move towards the edge of the box.

We have implemented 5 Classes: Ball class, Population class, Evolution class, Fitness class and Main class. 
Ball class mainly focus on defining the DNA (Coordinates, Fitness and Size).
Population and Evolution class together focus on how the DNA was translated to current coordinates and the mutation process. 
The Population class mainly contains the whole list of balls and maintains the current co-ordinates, size and fitness of the ball. 
Evolution class takes care of activities like reproduction and death.
Fitness class has methods to evaluate the fitness of each ball and selects the population for evolution. 
Main class stores the parameters for running the program.
