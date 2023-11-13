# CS611 - Assignment 4 - Legends-Heroes and Monsters

Aru Pandey 
U14204225

## Files
### 1. Board.java
 this class provides a generic structure for different types of game boards, and subclasses need to implement the setColorForCell method to define how the color of each cell should be set based on specific game requirements.
### 2. Cell.java
This class encapsulates the properties of a cell on the game board and allows for manipulation of its content, type, and color. The ANSI color codes are used to add color to the console output when printing the cell.
### 3. GameWorld.java
This class encapsulates the logic for initializing and printing the game world, setting colors for different cell types, and managing player position. The Cell class is utilized to represent individual cells on the game board.
### 4. Being.java
This abstract class encapsulates common properties and methods shared between heroes and monsters in the game. Subclasses will extend this class to provide specific implementations for heroes and monsters.
### 5. DataHero.java
The class utilizes file reading mechanisms to extract hero data, creates Hero objects, and provides a method to print the information in a formatted manner.
###6. DataMonster.java
The class employs file reading mechanisms to extract monster data, creates Monster objects, and provides a method to print the information in a formatted manner.
### 7. FileDataInput
The interface enforces a contract for classes to provide a method for reading character data from files, promoting consistency in handling data for different character types in the game.
### 8. Hero.java
The class encapsulates the functionality required for hero interactions in the game, including combat, equipment management, and attribute adjustments.
### 9. Monster.java
The class encapsulates the behavior of monsters during combat, providing methods for attacking heroes, defending against hero attacks, and handling dodge mechanisms.
### 10. Battle.java
The class orchestrates the flow of the battle, allowing heroes to take actions, checking battle status, generating monsters, and displaying relevant information.
### 11. Brief Summary
The class facilitates player choices, movement, and interactions with various game elements, creating a cohesive gameplay experience.
### 12. MarketPlace.java
The MarketPlace class in your Java code represents a market where game characters (heroes) can buy and sell various items such as weapons, armors, potions, and spells.
### 13. AllSpells.java
AllSpells class encapsulates the common properties of spells and provides methods for retrieving and displaying information about them. It seems well-structured and makes use of inheritance and encapsulation principles.
### 14. Armory.java
the Armory class encapsulates the specific properties of armors, follows the principles of inheritance and encapsulation, and provides methods for retrieving and displaying information about them.
### 15. Items.java
 the Items abstract class defines the shared characteristics of items in the market, promoting code organization and extensibility through inheritance. Subclasses are expected to provide specific implementations for their respective item types.
 ### 16. Potions.java
  the Potions class represents a specific type of item in the game, namely potions, with attributes related to attribute increase and the affected attribute. The class is designed to work in conjunction with other item classes within the game system.
### 17. Weapons.java
the Weapons class represents a specific type of item in the game, namely weapons, with attributes related to damage and the number of required hands. The class is designed to work in conjunction with other item classes within the game system.
### 18. Main.java
A concise main class.

## Notes
1. Some bits of the code for classes "Board" and "Cell" are  from my previous Assignments due to its extendability to use the board in other board games.
2. Written in a modular and extensible fashion.
3. Added general method to print in a specific color
### How to run and compile: 
1. Unzip contents
2. IntelliJ recommended: Open the folder in the IDE, and go to src/App.java and click on run button.
###Terminal
1. Navigate to the unzipped folder
2. Go to the unzipped folder
3. Run the following commands:
javac App.java
java App

## Input/Output
Welcome to: 'Legends: Heros and Monsters'!
choose 1-3 heros as a team and explore the world.
"'X: ' inaccessible spot, 'M: ' market, " + "'H: 'heros' position"
choose 1-3 heros as a team and explore the world.
movements: 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.
S/s: Move down.
A/a: Move left.
D/d: Move right
I/i: Show information.
Q/q: quit
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
enter no. of heros:(1-3)
1
There are 1 hero(s) in your team
Please choose 1 heroes to make the team
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
No |     Name   | Strength | Agility | Dexterity | Money | experience | Type
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
1   Parzival           | 750      | 650     | 700       | 2500  | 0          | 7
2   Sehanine_Moonbow   | 750      | 700     | 700       | 2500  | 0          | 7
3   Skoraeus_Stonebones | 650      | 600     | 350       | 2500  | 0          | 4
4   Garl_Glittergold   | 600      | 500     | 400       | 2500  | 0          | 5
5   Amaryllis_Astra    | 500      | 500     | 500       | 2500  | 0          | 5
6   Caliber_Heist      | 400      | 400     | 400       | 2500  | 0          | 8
7   Rillifane_Rallathil | 750      | 450     | 500       | 2500  | 0          | 9
8   Segojan_Earthcaller | 800      | 500     | 650       | 2500  | 0          | 5
9   Reign_Havoc        | 800      | 800     | 800       | 2500  | 0          | 8
10  Reverie_Ashels     | 800      | 700     | 400       | 2500  | 0          | 7
11  Kalabar            | 850      | 400     | 600       | 2500  | 0          | 6
12  Skye_Soar          | 700      | 400     | 500       | 2500  | 0          | 5
13  Gaerdal_Ironhand   | 700      | 500     | 600       | 1354  | 0          | 7
14  Sehanine_Monnbow   | 700      | 800     | 500       | 2500  | 0          | 8
15  Muamman_Duathall   | 900      | 500     | 750       | 2546  | 0          | 6
16  Flandal_Steelskin  | 750      | 650     | 700       | 2500  | 0          | 7
17  Undefeated_Yoj     | 800      | 400     | 700       | 2500  | 0          | 7
18  Eunoia_Cyn         | 700      | 800     | 600       | 2500  | 0          | 6
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
enter hero no.: (1-18)
3
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
No |        Name       | Strength | Agility | Dexterity | Money | experience | Type | Status
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
1    Garl_Glittergold      600       500       400        2500        0         5         false
No Armor!
No Weapon!
Your team is at: (1,0)
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
| H |   |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M |   | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | M |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
Press i: information/ m: to move your hero!
m
Choose a direction to move:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
| H |   |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M |   | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | M |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
d
Press i: information/ m: to move your hero!
m
Choose a direction to move:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
|   | H |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M |   | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | M |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
s 
Garl_Glittergold: Welcome to market. buy/sell items here. 0 to leave.
Do you want to buy or sell: 0: leave, 1: buy, 2: sell
m
Invalid input. Must be an integer.
Do you want to buy or sell: 0: leave, 1: buy, 2: sell
1
choose an item : 0(back) 1(Weapons), 2(Armours), 3(Spells), 4(Potions)
1
Choose weapons to buy:(1:1st item, 2:2nd item.....)
Weaponry
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
No |      Name     |  Cost  |  Required_Level  |  Damage  |  Required_Hand
1   Sword             500           1               800           1
2   Bow               300           2               500           2
3   Scythe            1000          6               1100          2
4   Axe               550           5               850           1
5   TSwords           1400          8               1600          2
6   Dagger            200           1               250           1
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

1
Succesful! You got: Sword
choose an item : 0(back) 1(Weapons), 2(Armours), 3(Spells), 4(Potions)
0
Press i: information/ m: to move your hero!
m
Choose a direction to move:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   | H |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M |   | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | M |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
s
FIGHT!!!
Monster Info: 
Monster Info: 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1   Desghidorrah        300       3         300       400       35.0      Alive
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Round 1 of the fight
Hero Info: 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
No |        Name       | HP | Mana | Strength | Agility | Dexterity | Money | experience | Type | Status
1    Garl_Glittergold      100       100       600       500       400       2000      0         Alive
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Monster Info: 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
No |      Name     | HP | Level  |  Damage  |  Defense | Dodge_Chance | Type | Status
1   Desghidorrah        300       3         300       400       35.0      Alive
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
It's hero Garl_Glittergold's turn!
Below are the operations you can choose during the fight:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
1: Attack
2: Change Weapon
3: Change Armor     
4: Use potion
5: Cast a spell     
6: Quit.
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
1
Hero Garl_Glittergold chooses to attack!
Desghidorrah dodged the attack from Garl_Glittergold.
Hero Garl_Glittergold has been knocked out!
Monster Desghidorrah caused 300 damage to the hero Garl_Glittergold
All heroes are faint! Game Over!
Press i: information/ m: to move your hero!
m
Choose a direction to move:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M | H | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | M |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
s
Garl_Glittergold: Welcome to market. buy/sell items here. 0 to leave.
Do you want to buy or sell: 0: leave, 1: buy, 2: sell
Invalid input. Must be an integer.
Do you want to buy or sell: 0: leave, 1: buy, 2: sell
0
Thanks for trading!
Press i: information/ m: to move your hero!
m
Choose a direction to move:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M |   | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | H |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+
a
Inaccessible area. Try another direction.
Choose a direction to move:
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
W/w: Move up.            S/s: Move down.
A/a: Move left.          D/d: Move right
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+---+---+---+---+---+---+---+---+
|   |   |   |   |   | M |   | X |
+---+---+---+---+---+---+---+---+
|   |   |   |   | X |   |   |   |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M |   | M |   |
+---+---+---+---+---+---+---+---+
| M |   | M | M |   | M | X | M |
+---+---+---+---+---+---+---+---+
| X | H |   |   | X | X | M | X |
+---+---+---+---+---+---+---+---+
|   | X | M |   |   | X |   | M |
+---+---+---+---+---+---+---+---+
| M |   |   |   | X | X |   |   |
+---+---+---+---+---+---+---+---+
| M |   | X |   |   |   |   | M |
+---+---+---+---+---+---+---+---+