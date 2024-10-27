# Информация о проекте.  
Необходимо организовать систему учета для питомника в котором живут домашниеивьючныеживотные.  
## Задание  
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные(заполнив файл собаками, кошками и хомяками) и Вьючные животными (заполнив файл Лошадьми,верблюдами и ослами), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав емуновоеимя(Друзьячеловека).
#### Выполнение
![Задание 1](https://github.com/ArtRadchenko/AnimalHub/blob/main/Screenshots/task01.jpg)  

2. Создать директорию, переместить файл туда.
#### Выполнение
![Задание 2](https://github.com/ArtRadchenko/AnimalHub/blob/main/Screenshots/task02.jpg)  

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
#### Выполнение
![Задание 3](https://github.com/ArtRadchenko/AnimalHub/blob/main/Screenshots/task03.jpg)  

4. Установить и удалить deb-пакет с помощью dpkg.
#### Выполнение
![Задание 4](https://github.com/ArtRadchenko/AnimalHub/blob/main/Screenshots/task04.jpg)  

5. Выложить историю команд в терминале ubuntu.
#### Выполнение
[История команд](https://github.com/ArtRadchenko/AnimalHub/blob/main/bash.txt) в терменале Ubuntu.  

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные,в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюдыиослы.
#### Выполнение
![Задание 6](https://github.com/ArtRadchenko/AnimalHub/blob/main/Screenshots/uml.jpg)  

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”.
#### Выполнение
```sql
CREATE DATABASE mans_friends;
```  

8. Создать таблицы с иерархией из диаграммы в БД.  
#### Выполнение
```sql
CREATE TABLE Animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);

CREATE TABLE DomesticAnimal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES Animal(id),
    play BOOLEAN DEFAULT FALSE
);

CREATE TABLE PackAnimal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES Animal(id),
    carry_load BOOLEAN DEFAULT FALSE
);

CREATE TABLE Dog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    domestic_animal_id INT,
    breed VARCHAR(50) NOT NULL,
    FOREIGN KEY (domestic_animal_id) REFERENCES DomesticAnimal(id)
);

CREATE TABLE Cat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    domestic_animal_id INT,
    color VARCHAR(30) NOT NULL,
    FOREIGN KEY (domestic_animal_id) REFERENCES DomesticAnimal(id)
);

CREATE TABLE Hamster (
    id INT AUTO_INCREMENT PRIMARY KEY,
    domestic_animal_id INT,
    size VARCHAR(30) NOT NULL,
    FOREIGN KEY (domestic_animal_id) REFERENCES DomesticAnimal(id)
);

CREATE TABLE Horse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id INT,
    breed VARCHAR(50) NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES PackAnimal(id)
);

CREATE TABLE Camel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id INT,
    type VARCHAR(50) NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES PackAnimal(id)
);

CREATE TABLE Donkey (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id INT,
    breed VARCHAR(50) NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES PackAnimal(id)
);
```