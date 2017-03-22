# 4-Gewinnt

![alt logo](https://github.com/Lukas-Skywalker/4-Gewinnt/blob/master/4-Gewinnt%20Etappe%205/app/src/main/res/drawable/logo.png)

Eine bunte Version des klassischen Spiels 4 Gewinnt als Android App. Nachdem man den Button zum Starten des Spiels gedrückt hat, erscheint die standardmäßig blaue Oberfläche des 4 Gewinnt Spiels. Mit einfachen Clicks auf die jeweilige Spalte wirft man in diese einen Spielstein. Die Spieler spielen abwechselnd. Dabei kontrolliert die App jederzeit, ob ein Gewinner feststeht. Falls dies der Fall ist informiert sie die Spieler darüber und kehrt zum Startbildschirm zurück.

#### Startbildschirm
![alt logo](https://github.com/Lukas-Skywalker/4-Gewinnt/blob/master/Screenshots/Startbildschirm.png) 
Der Startbildschirm zeigt den Button zum Start des Spiels

#### Spieldfeld
![alt logo](https://github.com/Lukas-Skywalker/4-Gewinnt/blob/master/Screenshots/Spielfeld.png)
Die standardmäßig blaue Spielfläche mit Androiden als Spielsteine




## Etappen
#### Etappe 1
 - Anlegen der StartActivity
 - Anpassen der ScreenOrientation im Manifest auf landscape für StartActivity
 - Styles.xml anpassen um ActionBar zu entfernen
 - Colors.xml anpassen nach Wunsch
 - Button in das Layout der StartActivity einfügen

#### Etappe 2
 - Anlegen der MainActivity
 - Button aus StartActivity über findViewById() holen und speichern
 - Dem Button einen OnClickListener verpassen
 - In der Methode onClick() einen Intent zum Start der MainActivity.class generieren
 - In der Methode onClick() die Activity Starten

#### Etappe 3
 - Anpassen der ScreenOrientation im Manifest auf landscape für MainActivity
 - Als Wurzellayout ein horizontales LinearLayout einfügen mit Eigenschaften:
   * weightSum = 7
 - In das Wurzellayout 7 vertikale LinearLayouts einfügen mit Eigenschaften:
#### Etappe 4

#### Etappe 5
