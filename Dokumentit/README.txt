==========Ohjelman kättöohjeet==========
Ohjelma voidaan käynnistää suoraan Tiralabra_Astar_ja_Dijkstra_vertialu.jar tiedostosta.
Se voidaan myös suorittaa esim. NetBeansista. Oma NetBeans versioni työtä tehdessä oli 7.4.
Jos ohjelman käynnistää jarrista suoraan kannattaa odottaa hetkinen, koska taulukko on 50*50 ja Dijkstralla kestää 
hetkinen. 

Ohjelma ottaa syötteenä hiiren paianalluksia eli jos haluaa asettaa esteitä tai ottaa niitä pois sen voi tehdä hiirtä klikkaamalla.

Alku ja loppupistettä voi muuttaa vain koodista käsin, muttei hiirellä suorituksen aikana. Jos haluaa muuttaa alku ja/tai loppupistettä kannattaa mennä GUI paketin sisälle ja sieltä MainWindow luokkaan.
Sieltä löytyy riviltä 92 ja 93 (olettaen ettei ole muuttanut mitään) seuraavat:


								   mikä    onko
				       maaliY maalix alkuY alkuX  int[][] painotettu
									  (tarvitaan dijkstraan)
------------------------------------------------------------------------------------
	astar=new Astar(new Verkko      (0,    49,    49,   49,   verkko,  false));

        dijkstra=new Dijkstra(new Verkko(0,    49,    49,   49,   verkko2, true));

näitä arvoja muuttamalla voi säätää verkon alku ja loppupistettä, sekä minkä taulukon pohjalta verkko tehdään ja piirretään.
Painotettu verkko tarvitaan dijkstran algoritmiin, eli nämä arvot kannattaa pitää sellaisenaan.

Jos haluaa erikokoisen verkon täytyy käydä luokan alussa muuttamassa seuraavia rivejä (33,34):

1.
    private int[][] verkko=new int[50][50];
    private int[][] verkko2=new int[50][50];

Näihin voi antaa sitten haluamansa arvot.

2. Sitten pitää mennä vielä konstruktorin alkuun (rivit 53,54): 
	astarPanelGrid=new JPanel[50][50];
        dijkstraPanelGrid=new JPanel[50][50];
ja muuttaa nämä arvot SAMOIKSI kuin muutit 1. kohdassa.

3. Muista vielä mennä asettamaan maali ja lku oikeisiin paikkoihin tai muuten ne voivat olla verkon ulkopuolella. Tämä kaataisi ohjelman.

(4. vaihtoehtoiset esteet): 
Jos haluaa esteitä, voi ne joko laittaa käsin tai tehdä int taulukot, joissa ne ovat valmiina. Itse tein vähän rumaa koodia ja lisäsin käsin muutaman esteen (rivit 56-90!).