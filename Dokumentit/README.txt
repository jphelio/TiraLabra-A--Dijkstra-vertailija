==========Ohjelman k�tt�ohjeet==========
Ohjelma voidaan k�ynnist�� suoraan Tiralabra_Astar_ja_Dijkstra_vertialu.jar tiedostosta.
Se voidaan my�s suorittaa esim. NetBeansista. Oma NetBeans versioni ty�t� tehdess� oli 7.4.
Jos ohjelman k�ynnist�� jarrista suoraan kannattaa odottaa hetkinen, koska taulukko on 50*50 ja Dijkstralla kest�� 
hetkinen. 

Ohjelma ottaa sy�tteen� hiiren paianalluksia eli jos haluaa asettaa esteit� tai ottaa niit� pois sen voi tehd� hiirt� klikkaamalla.

Alku ja loppupistett� voi muuttaa vain koodista k�sin, muttei hiirell� suorituksen aikana. Jos haluaa muuttaa alku ja/tai loppupistett� kannattaa menn� GUI paketin sis�lle ja sielt� MainWindow luokkaan.
Sielt� l�ytyy rivilt� 92 ja 93 (olettaen ettei ole muuttanut mit��n) seuraavat:


								   mik�    onko
				       maaliY maalix alkuY alkuX  int[][] painotettu
									  (tarvitaan dijkstraan)
------------------------------------------------------------------------------------
	astar=new Astar(new Verkko      (0,    49,    49,   49,   verkko,  false));

        dijkstra=new Dijkstra(new Verkko(0,    49,    49,   49,   verkko2, true));

n�it� arvoja muuttamalla voi s��t�� verkon alku ja loppupistett�, sek� mink� taulukon pohjalta verkko tehd��n ja piirret��n.
Painotettu verkko tarvitaan dijkstran algoritmiin, eli n�m� arvot kannattaa pit�� sellaisenaan.

Jos haluaa erikokoisen verkon t�ytyy k�yd� luokan alussa muuttamassa seuraavia rivej� (33,34):

1.
    private int[][] verkko=new int[50][50];
    private int[][] verkko2=new int[50][50];

N�ihin voi antaa sitten haluamansa arvot.

2. Sitten pit�� menn� viel� konstruktorin alkuun (rivit 53,54): 
	astarPanelGrid=new JPanel[50][50];
        dijkstraPanelGrid=new JPanel[50][50];
ja muuttaa n�m� arvot SAMOIKSI kuin muutit 1. kohdassa.

3. Muista viel� menn� asettamaan maali ja lku oikeisiin paikkoihin tai muuten ne voivat olla verkon ulkopuolella. T�m� kaataisi ohjelman.

(4. vaihtoehtoiset esteet): 
Jos haluaa esteit�, voi ne joko laittaa k�sin tai tehd� int taulukot, joissa ne ovat valmiina. Itse tein v�h�n rumaa koodia ja lis�sin k�sin muutaman esteen (rivit 56-90!).