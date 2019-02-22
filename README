Here's a Command Line based role playing game
To run - build project with gradle and execute jar file as follows:
java -jar snowman.jar

To extend this game take a look at the short design overview.

Main four entities are : Stage, Command, View and Context.
The core concept is MVC pattern. Each Stage Implementation defines Context (Model),
View and CommandFactory which provides Command implementations (Controllers)

Game loop is presented in CommonStage Class, in a nutshell it goes like this:
Wait for user command
Process this command (By changing the context)
Show the view for specified Context
If current Stage is stopped go to the next one (if it exists)

Restrictions and Limitations:
Currently tested on Mac Terminal only, May not work correctly on other Terminals!

Screenshots:

![alt=start](./screenshots/Start.png)

[[https://github.com/Larrylurex/arcade/blob/master/screenshots/Story.png|alt=story]]
[[https://github.com/Larrylurex/arcade/blob/master/screenshots/Characters.png|alt=characters]]
[[https://github.com/Larrylurex/arcade/blob/master/screenshots/Round.png|alt=round]]
[[https://github.com/Larrylurex/arcade/blob/master/screenshots/Fight.png|alt=fight]]
[[https://github.com/Larrylurex/arcade/blob/master/screenshots/Won.png|alt=won]]
