# Assignment 2 (Part-1)
### Note: 
 In this assignment I  have take my own code from other course as a part for this assignment.

# Implementation smells

## Complex method
#### Package Name : 
Assignment2
#### Class Name : 
SearchTree
### Method Name : 
private void shiftTreeStructure(NodeManager node)
#### Line number :
169
#### Changes made : 
Previously it was two different method for Right rotate and Left rotate I have combined them in one method to make it a complex method. 

## Long parameter list
#### Package Name : 
Assignment2
#### Class Name : 
NodeManager
### Method Name : 
public NodeManager(String key, int count, NodeManager left, NodeManager right, NodeManager parent)
#### Line number :
33
#### Changes made : 
Previously it only accpets 2 parameter but i increased the parameter count to introduce smell. 

## Complex conditional
#### Package Name : 
Assignment2
#### Class Name : 
SearchTree
### Method Name : 
public int find(String key)
#### Line number :
126
#### Changes made : 
Previously it only check for null condition but I introduce 2 other conditions to make it a complex condition smell. 

## Long method
#### Package Name : 
Assignment2
#### Class Name : 
SearchTree
### Method Name : 
private void shiftTreeStructure(NodeManager node)
#### Line number :
169
#### Changes made : 
Previously it was two different method for Right rotate and Left rotate I have combined them in one method to make it a long and complex method. 


## Design smells

### Deficient encapsulation
#### Package Name : 
Assignment2
#### Class Name : 
NodeManager
#### Line number :
4
#### Changes made : 
Previously the global variables were private and follow encapsulation rule but I made it public which violates it. 

### Cyclic hierarchy
#### Package Name : 
Assignment2
#### Class Name : 
NodeManager
#### Line number :
4
#### Changes made : 
Previously class depends on SearchTree class to perfrom its oberations and SearchTree class depends on NodeManager class to make nodes for the tree strudture which make it tight coupled. 

### Rebellious hierarchy
#### Package Name : 
Assignment2
#### Class Name : 
AVLTree
#### Line number :
3
#### Changes made : 
Previously I have added AVLTree class and BinaryTree class which are child of SearchTree class and each class have property method which does different operations for each tree type and cannot be used by SearchTree class and it doesnt follow abstraction and violates it and generate smell.


## Architecture smells

### Cyclic dependency
#### Package Name : 
Assignment2
#### Changes made : 
Previously class depends on SearchTree class to perfrom its oberations and SearchTree class depends on NodeManager class to make nodes for the tree strudture which make it tight coupled. 

### Feature concentration
#### Package Name : 
Assignment2
#### Changes made : 
All the classes in the project are created under a same Package which make it difficult to access the class and define class properties based in their package so it is a Feacture concentration smell.