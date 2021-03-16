# Library-App
Aplicatia este destinata librariilor si bibliotecilor prin care se pot imprumuta sau vinde carti, se poate vizualiza stocul initial al institutiei sau vederea unor statistici in vederea evoluarii companiei. Cu o simpla logare, puteti fi angajat, administrator sau doar un client.

Aplicatia este formata clasa ObjectClass care este clasa de BAZA pentru toate clasele aplicatiei din pachetul DOMAIN. Avem o clasa Users care este clasa de baza pentru clasele Client,Admin,Eployee si care la randul ei este clasa parinte pentru ObjectClass

ObjectClass -> Users -> Client, Employee, Admin
            
ObjectClass -> Author
            
ObjectClass -> Publisher
            
ObjectClass -> Book
 
Aplicatia foloseste mult conceptul de POLIMORFISM, mai ales la crearea claselor din pachetul DOMAIN. Avem si clasere Repository care este unul generic si bineinteles un service. Aplicatia are ca functionalitati CRUD-uri pentru toate clasele, modalitatea de imprumut a unei cartisi vizualizarea unor statistici importante.
Aplicatia are si o interfata grafica. La pornirea acesteia ne putem loga sau inregistra, iar in functie de username, vom fi CLIENTI, sau ANGAJATI, sau ADMINISTRATORI, astfel 3 ferestre diferite se vor putea deschide.

Imagine din timpul logarii: ![image](https://user-images.githubusercontent.com/62211568/111371445-14663a80-86a2-11eb-8779-c531044e45d1.png)

Imagine din timpul inregistrarii: ![image](https://user-images.githubusercontent.com/62211568/111371563-47a8c980-86a2-11eb-87fb-724dc2e6f7c6.png)
