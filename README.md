# Architecture-logicielles
Manipuler les concepts de bases préliminaires des architecture logicielles : Architecture en couches, ClientEjb, JPA           
C'est une application programmée en JAVA pour une vidéothèque (magasin de vente de films, jeux...) implémentée avec une architecture Pipe & Filter. Les filtres sont les classes : GUI (JavaFX), QueryProcessor et TransactionProcessor (GUI | QueryProcessor | TransactionProcessor | GUI... cyclique). Le pipe est implémenté par le biais d'une file de chaines de caractères pour stocker les messages entre filtres et notifier le prochain pour faire son traitement.

les fonctionnalités de l'application :

    Quels sont tous les films dans lesquels un acteur a joué ? donnés ?
    Y a-t-il un jeu ou un film avec un titre donné qui est disponible à la location ?
    Quels sont tous les films qu'un client donné a loués, avec leurs dates d'échéance ?
    Quel est le solde du compte d'un client et quels sont tous les articles en retard ?
    Louer et livrer un article par un client
    Ajouter des amendes à votre solde (pénalités de retard)
    Ajouter un article au stock et mettre à jour le catalogue
    Ajouter un client


