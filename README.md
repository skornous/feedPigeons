# feedPigeons 

##Developpers

* Nicolas BERNARD
* Hugo GENNARO

##Start things up
Right now you can't, but, it should look like that at the end : "Run the .jar file"

##Sum up demand
*For the ones that can't read the exact demand (because it's in french)*

Let's feed some birds !

So, basically we need to do a bird feeding simulation where each bird is represented by a Thread

Possibilities :

* Pigeons fall asleep when they don't get feed for "too long" (need to be defined)
* When a pigeon see food, he "run" (well, move) toward it to eat it
* Rotted food don't get eaten
* Birds can get scared by a random event, making them run all over the map (or away)
* There can be only one bird that eat one specific food piece

##Exact demand
*Post-reading warning : this is in french, the closest thing to a translation is the sum up*

Pour ce travail, on donnera � manger aux Pigeons !!  Le but est d�impl�menter une simulation d�alimentation de pigeon
dans un espace public.  Le jeu se passe dans une fen�tre o� les pigeons attendent la nourriture. L�utilisateur, alors,
leur donne � manger en cliquant sur un emplacement dans la fen�tre. Les pigeons suivent les r�gles suivantes :

1. Chaque pigeon est contr�l� par un thread
2. Si rien ne se passe, les pigeons s�endorment et ne bougent pas
3. En apercevant de la nourriture, un pigeon se d�place vers la nourriture la plus fraiche.
4. Une nourriture fraiche touch�e est mang�e, donc elle doit disparaitre imm�diatement de la sc�ne.
5. Nos pigeons sont g�t�s ; un pigeon qui touche une nourriture pas fraiche, il l�ignore.
6. M�me en l�absence de la nourriture, des fois les pigeons se font effrayer et ils se dispersent � des positions
al�atoires. Int�grer se m�canisme dont la probabilit� d�occurrence change d�un tour � l�autre.

Les pigeons et la nourriture doivent �tre repr�senter graphiquement. Un simple cercle ou un objet 3D, c�est � vous de
choisir.  Le plus important est le multithreading et la structure des classes. En ce qui Concerne le multithreading,
vous serai amen� � :

1. S�assurer que les pigeons arr�tent de bouger le moment o� il ne reste plus de nourriture.
2. Aussi, s�assurer si plus qu�un pigeon touche la nourriture simultan�ment, uniquement un seul
pourra la supprimer.
3. Prendre en compte la nourriture dans le processus de dessin. Puisque les threads ne sont pas
synchronis�s, ceci permet d�ajouter de la nourriture m�me au moment du dessin de la sc�ne.

Il sera commode de parcourir une structure de nourriture et de faire un verrou pendant le processus de dessin.

Vous avez le choix en tout ce qui est la conception des pigeons, leurs comportements, leurs
dimensions sur la fen�tre, vitesse, le nombre � votre code est cens� �tre robuste, des exceptions non
g�r�es coutent des points.

# License
This project is under the MIT license, for more information go check the LICENSE.txt file 