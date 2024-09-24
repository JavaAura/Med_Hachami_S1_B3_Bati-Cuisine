CREATE TYPE statut_project AS ENUM ('EnCours', 'Terminé', 'Annulé');
CREATE TYPE TypeComposant AS ENUM ('materiel', 'labor');

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE projects TO root;

GRANT USAGE, SELECT ON SEQUENCE projects_id_seq TO root;

    CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    marge_beneficiaire DOUBLE PRECISION NOT NULL,
    cout_total DOUBLE PRECISION,
    etat_projet statut_project DEFAULT 'EnCours' NOT NULL,  
    client_id INT,
    CONSTRAINT fk_client
        FOREIGN KEY (client_id) REFERENCES client (id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE projects TO your_user;

GRANT USAGE, SELECT ON SEQUENCE projects_id_seq TO root;

  CREATE TABLE clients (
       id SERIAL PRIMARY KEY,
       nom VARCHAR(255) NOT NULL,
       adresse VARCHAR(255) NOT NULL,
       telephone VARCHAR(15) NOT NULL,
       estprofessionnel BOOLEAN NOT NULL
   );


   CREATE TABLE composant (
        id SERIAL PRIMARY KEY,
        nom VARCHAR(255) NOT NULL,
        type_composant TypeComposant NOT NULL,
        taux_tva DOUBLE PRECISION NOT NULL,
        projet_id INT,
        CONSTRAINT fk_projet FOREIGN KEY (projet_id) REFERENCES projects (id)
    );


GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE composant TO root;

GRANT USAGE, SELECT ON SEQUENCE composant_id_seq TO root;



   CREATE TABLE materiel (
        cout_unitaire DOUBLE PRECISION NOT NULL,
        quantite DOUBLE PRECISION NOT NULL,
        cout_transport DOUBLE PRECISION,
        coefficient_qualite DOUBLE PRECISION
    )INHERITS (composant);

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE materiel TO root;


    CREATE TABLE labor (
        taux_horaire DOUBLE PRECISION NOT NULL,
        heures_travail DOUBLE PRECISION NOT NULL,
        productivite_ouvrier DOUBLE PRECISION
    )INHERITS (composant);

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE labor TO root;



CREATE TABLE devis (
    id SERIAL PRIMARY KEY,
    montant_estime DOUBLE PRECISION NOT NULL,
    date_emission DATE NOT NULL,
    date_validite DATE NOT NULL,
    accepte BOOLEAN NOT NULL,
    projet_id INT UNIQUE, 
    CONSTRAINT fk_projet FOREIGN KEY (projet_id) REFERENCES projects (id)
    ON DELETE CASCADE
);



GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE devis  TO root;
GRANT USAGE, SELECT ON SEQUENCE devis_id_seq TO root;   
