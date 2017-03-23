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
   * layout_width = match_parent
   * layout_height = match_parent
   * background= @color/colorPrimary
 - In das Wurzellayout 7 vertikale LinearLayouts einfügen mit Eigenschaften:
   * weightSum = 6
   * layout_width = 0dp
   * layout_height = match_parent
   * layout_weight = 1
   * gravity = bottom
   * ids vergeben
   
#### Etappe 4
 - In der MainActivity Array vom Typ LinearLayout anlegen
 - In der onCreate() das Array mit den 7 vertikalen LinearLayouts befüllen
 - Das Bild "field.png" aus diesem Repository in den drawable Ordner einfügen
 - Code in die onCreate() einfügen
```java
 for (int j = 0; j < 7; j++) {
     for (int i = 0; i < 6; i++) {
         ImageView image = new ImageView(this);
         image.setImageDrawable(getResources().getDrawable(R.drawable.field));
         LinearLayout.LayoutParams params = 
             new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
         linearLayouts[j].addView(image, params);
     }
 }
```
#### Etappe 5
 - Die Klasse Game aus diesem Repository in das Projekt einfügen
 - Das Bilder "logo.png", "stone_red.png" und "stone_yellow.png" aus diesem Repository in den drawable Ordner einfügen 
 - In der MainActivity zweidimensionales Array vom Typ ImageView anlegen
 - In der MainActivity Datenelement vom Typ Game deklarieren und initialisieren
 - Code in innnerste Schleife aus Etappe 4 einfügen
```java
 imageViews[j][i] = image;
```
 - Code in äußere Schleife aus Etappe 4 einfügen und onClick() generieren
```java
 linearLayouts[j].setTag(j);
 linearLayouts[j].setOnClickListener(this);
```
 - Code in onClick() einfügen
 ```java
 LinearLayout linearLayout = (LinearLayout) view;
 
 int column = (Integer) linearLayout.getTag();
 int row = game.insert(column);
 
 if (row >= 0) {
     if (game.getPlayerTurn() == Game.Player.P1) {
         imageViews[column][row].setImageDrawable(getResources().getDrawable(R.drawable.stone_red));
     } else {
         imageViews[column][row].setImageDrawable(getResources().getDrawable(R.drawable.stone_yellow));
     }
 
     if (game.checkWin()) {
         Toast.makeText(this, "Spieler " + game.getPlayerTurn().name() + " hat gewonnen", Toast.LENGTH_LONG).
             show();
         finish();
     }
 
     game.nextPlayer();
 }
```
 - Icon der App im Manifest ändern
