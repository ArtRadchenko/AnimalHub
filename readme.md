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
-- Таблица для хранения общих данных о животных
CREATE TABLE Animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    age INT NOT NULL
);

-- Таблица для домашних животных
CREATE TABLE DomesticAnimal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    play BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (animal_id) REFERENCES Animal(id)
);

-- Таблица для вьючных животных
CREATE TABLE PackAnimal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    carry_load BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (animal_id) REFERENCES Animal(id)
);

-- Таблица для собак
CREATE TABLE Dog (
    id INT AUTO_INCREMENT PRIMARY KEY,
    domestic_animal_id INT,
    breed VARCHAR(50) NOT NULL,
    FOREIGN KEY (domestic_animal_id) REFERENCES DomesticAnimal(id)
);

-- Таблица для кошек
CREATE TABLE Cat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    domestic_animal_id INT,
    color VARCHAR(30) NOT NULL,
    FOREIGN KEY (domestic_animal_id) REFERENCES DomesticAnimal(id)
);

-- Таблица для хомяков
CREATE TABLE Hamster (
    id INT AUTO_INCREMENT PRIMARY KEY,
    domestic_animal_id INT,
    size VARCHAR(30) NOT NULL,
    FOREIGN KEY (domestic_animal_id) REFERENCES DomesticAnimal(id)
);

-- Таблица для лошадей
CREATE TABLE Horse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id INT,
    breed VARCHAR(50) NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES PackAnimal(id)
);

-- Таблица для верблюдов
CREATE TABLE Camel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id INT,
    type VARCHAR(50) NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES PackAnimal(id)
);

-- Таблица для ослов
CREATE TABLE Donkey (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pack_animal_id INT,
    breed VARCHAR(50) NOT NULL,
    FOREIGN KEY (pack_animal_id) REFERENCES PackAnimal(id)
);

-- Таблица для хранения команд, которые выполняют животные
CREATE TABLE Commands (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    command VARCHAR(50) NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animal(id)
);
```  

9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения.
#### Выполнение
```sql
INSERT INTO Animal (name, birth_date, age) VALUES 
('Buddy', '2020-05-01', 3),   -- Собака
('Mittens', '2019-03-15', 4),  -- Кошка
('Hammy', '2021-07-20', 2),    -- Хомяк
('Spirit', '2018-10-10', 5),    -- Лошадь
('Coco', '2020-12-05', 2),      -- Верблюд
('Donny', '2019-08-22', 4);      -- Осел

INSERT INTO DomesticAnimal (animal_id, play) VALUES 
(1, TRUE),  -- Собака Buddy
(2, TRUE),  -- Кошка Mittens
(3, TRUE);  -- Хомяк Hammy

INSERT INTO PackAnimal (animal_id, carry_load) VALUES 
(4, TRUE),  -- Лошадь Spirit
(5, TRUE),  -- Верблюд Coco
(6, TRUE);  -- Осёл Donny

INSERT INTO Dog (domestic_animal_id, breed) VALUES 
(1, 'Labrador');  -- Собака Buddy

INSERT INTO Cat (domestic_animal_id, color) VALUES 
(2, 'Black');  -- Кошка Mittens

INSERT INTO Hamster (domestic_animal_id, size) VALUES 
(3, 'Small');  -- Хомячелло Hammy

INSERT INTO Horse (pack_animal_id, breed) VALUES 
(1, 'Arabian');  -- Лошадь Spirit

INSERT INTO Camel (pack_animal_id, type) VALUES 
(2, 'Dromedary');  -- Верблюд Coco

INSERT INTO Donkey (pack_animal_id, breed) VALUES 
(3, 'Standard');  -- Осёл Donny

INSERT INTO Commands (animal_id, command) VALUES 
(1, 'Sit'),       -- Собака Buddy
(2, 'Jump'),      -- Кошка Mittens
(3, 'Run'),       -- Хомяк Hammy
(4, 'Gallop'),    -- Лошадь Spirit
(5, 'Carry'),     -- Верблюд Coco
(6, 'Bray');      -- Осёл Donny
```  

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
#### Выполнение
```sql
DELETE FROM Camel WHERE pack_animal_id = 2;  -- Минус Верблюд Coco
```  

```sql
-- Создание новой таблицы Horsedonkey с объединенными данными
CREATE TABLE Horsedonkey AS
SELECT pack_animal_id, breed, 'Horse' AS type FROM Horse
UNION
SELECT pack_animal_id, breed, 'Donkey' AS type FROM Donkey;

-- Удаление старых таблиц
DROP TABLE Horse;
DROP TABLE Donkey;
```  
