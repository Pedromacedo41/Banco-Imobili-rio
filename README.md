# Banco-Imobiliario-Game

Java Board Game (Banco Imobliario), with IntelliJ IDEA and Javafx to design the UI
JDK 8 or superior to buid the project


_To execute_ open .jar Application 

_To Build_ open import /src and uses the javac and java commands. If your IDE supports it, import the project




Project using Singleton , where class 'partida' handlers the word context of the game  and the change of the views.
Some observations:

 - Each views has its controller under /Controllers and have an Initialize method to load the information needed.
The UI objects are injected on the controllers using ids tags inside fxml file. The design, however, was setted up 
using Scene Builder engine to render and build each window of the game

 - PrincipalController is the controller for the game board view and its single istance is shared through constructor
of the other views controllers. So the differents Windows of the game (in javafx named Stages instances) are synchronous

 - The chief Classes models are Jogador (Players of the game) and Casa. There are subclasses for the last one classes,
setting up the semantics and context to the game.  But that's the basics!
