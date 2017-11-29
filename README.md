# Assignment 9 - PokeGUI
## 100 Points
## Due Monday 12/11 (Final Exam day) 
----


In this assignment we are going to try to pull together much of what you have worked on all semester into a nice pretty package. 

The task is to build a Graphical User Interface (GUI) for your Pokemon species heirarchy that works somewhat like Pokemon Go without the GPS. 

You are encouraged to get creative with this. Make your application look nice! Some extra credit is defined, but adding other functionality will get additional points. 

*Some of you may know how to make better GUIs than others. If you have GUI experience and want to, go ahead and make something nicer than is described below. Just make sure it still performs the same tasks.*

----
***Example from previous semester:***

![sample GUI](https://github.com/ICSatKCC/Assignment9-PokeGUI/blob/master/pokegui.png "Sample GUI") 

The GUI should have two sections:
 * The top section will be for catching Pokemon.
 * The bottom section will be like your "backpack" and will display the list of captured Pokemon in various ways.
 * The whole thing should be built using Java JFrames and JPanels, plus components.
 
## Top Section - 50 points
Here there should be:
  * A TextField or TextArea big enough display one Pokemon's toString output.
  * A button titled "Hunt"
  * A button titled "Catch"
  
When the user clicks the "Hunt" button:
  * The program should randomly select one species of Pokemon and create it. 
  * The TextField should display "A Bulbasaur appeared!" (or whatever species was selected)
  
The user will then need to click the "Catch" button.
  * This will be equivalent of throwing a Pokeball
  * The program should then randomly decide whether or not the Pokemon actually gets caught.
   * If the Pokemon gets caught, the text field should display something like "Caught: " + ```<Pokemon>.toString()```
   * If not the TextField should display: "```<Pokemon>``` escaped"
   
### Extra Credit suggestion
 * Add a way to let the user give the caught Pokemon a name.
 
## Bottom Section - 50 points
This part of the program will use data structures you have already implemented to store Pokemon as they are caught in the upper section. 

Here there should be:
 * A TextArea for displaying a list of Pokemon
 * A button titled "Pokedex"
 * A button titled "Backpack"
 * A Choice pop-up menu for the sorting order with the following choices:
  * Number
  * Recent
  
When the user clicks the "Pokedex" button, the TextArea should display the output of printPokeTree from Assignment 7. 

When the user clicks the "Backpack" button, the TextArea should display a list of all Pokemon that have been caught, ordered by whatever Choice is selected.
 * The stack from Assignment 6 holds the Pokemons in the "Recent" order
 * The PriorityQueue from Assignment 6 holds them in "Number" order
 
### Extra Credit Sorting - 50 points
Add three more Choices to the pop-up menu for sorting order:
  * Name
  * HP
  * CP
 * You will need to implement sorting for these orders.
  * It is up to you how you accomplish this.
   * You may make separate data structures that keep the entire list sorted all the time.
   * Alternatively you could just do the sorts as needed.
   * You may make your own sorting methods, or use the Java List sort method with a Comparator
    * See this reference for how to use a Comparator: https://examples.javacodegeeks.com/core-java/util/comparator/java-comparator-example/

## Grading Rubric
 
### Top Section -  /50 points

- [ ] A TextField or TextArea big enough display one Pokemon's toString output.
- [ ] A button titled "Hunt"
- [ ] A button titled "Catch"

Click the "Hunt" button:
- [ ] Randomly selects one species of Pokemon and create it.
- [ ] The TextField  displays "A Bulbasaur appeared!" (or whatever species was selected)
 
Click the "Catch" button:
- [ ] Random Pokemon catching.
- [ ] If the Pokemon caught, the text field displays something like "Caught: " + ```<Pokemon>.toString()``` If not the TextField  displays: "```<Pokemon>``` escaped"

### Bottom Section - /50 points
- [ ] A TextArea for displaying a list of Pokemon
- [ ] A button titled "Pokedex"  displays the output of printPokeTree
- [ ] A button titled "Backpack" displays a list of all Pokemon that have been caught, ordered by whatever Choice is selected.
- [ ] A Choice pop-up menu for the sorting order with the following choices:Number Recent

### Extra Credit
