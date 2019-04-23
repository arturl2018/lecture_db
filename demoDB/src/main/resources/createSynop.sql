create table synop (id_stacji integer not null,
stacja varchar(50),
data_pomiaru date not null,
godzina_pomiaru integer not null,
temperatura numeric(4,2),
predkosc_wiatru numeric(5,2),
kierunek_wiatru numeric(5,2),
wilgotnosc_wzgledna numeric(5,2),
suma_opadu numeric(6,2),
cisnienie numeric(6,2),
PRIMARY KEY (id_stacji, data_pomiaru, godzina_pomiaru)
);

