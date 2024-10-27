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

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.
#### Выполнение
![Задание 6](https://github.com/ArtRadchenko/AnimalHub/blob/main/Screenshots/uml.jpg)  

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”.
#### Выполнение
```sql
CREATE DATABASE MansFriends;
```  

8. Создать таблицы с иерархией из диаграммы в БД.  
#### Выполнение
```sql
-- Создание таблицы для всех животных
CREATE TABLE animals (
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    AnimalType VARCHAR(30) NOT NULL
);

-- Создание таблицы для вьючных животных
CREATE TABLE packanimals (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    GenusName VARCHAR(50),
    TypeID INT,
    FOREIGN KEY (TypeID)
    REFERENCES animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для домашних животных
CREATE TABLE domesticanimals (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    GenusName VARCHAR(50),
    TypeID INT,
    FOREIGN KEY (TypeID)
    REFERENCES animals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для собак
CREATE TABLE dogs (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    DomesticAnimalID INT,
    Name VARCHAR(50),
    Command VARCHAR(50),
    BirthDate DATE,
    FOREIGN KEY (DomesticAnimalID)
    REFERENCES domesticanimals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для кошек
CREATE TABLE cats (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    DomesticAnimalID INT,
    Name VARCHAR(50),
    Command VARCHAR(50),
    BirthDate DATE,
    FOREIGN KEY (DomesticAnimalID)
    REFERENCES domesticanimals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для хомяков
CREATE TABLE hamsters (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    DomesticAnimalID INT,
    Name VARCHAR(50),
    Command VARCHAR(50),
    BirthDate DATE,
    FOREIGN KEY (DomesticAnimalID)
    REFERENCES domesticanimals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для лошадей
CREATE TABLE horses (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    PackAnimalID INT,
    Name VARCHAR(50),
    Command VARCHAR(50),
    BirthDate DATE,
    FOREIGN KEY (PackAnimalID)
    REFERENCES packanimals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для верблюдов
CREATE TABLE camels (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    PackAnimalID INT,
    Name VARCHAR(50),
    Command VARCHAR(50),
    BirthDate DATE,
    FOREIGN KEY (PackAnimalID)
    REFERENCES packanimals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Создание таблицы для ослов
CREATE TABLE donkeys (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    PackAnimalID INT,
    Name VARCHAR(50),
    Command VARCHAR(50),
    BirthDate DATE,
    FOREIGN KEY (PackAnimalID)
    REFERENCES packanimals(Id) ON DELETE CASCADE ON UPDATE CASCADE
);
```  

9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения.
#### Выполнение
```sql
-- Заполнение таблицы animals
INSERT INTO animals (Id, AnimalType) VALUES 
(1, 'Domestic'),  -- Домашние животные
(2, 'Pack');      -- Вьючные животные

-- Заполнение таблицы domesticanimals
INSERT INTO domesticanimals (GenusName, TypeID) VALUES 
('Dog', 1),  -- Собаки
('Cat', 1),  -- Кошки
('Hamster', 1);  -- Хомяки

-- Заполнение таблицы packanimals
INSERT INTO packanimals (GenusName, TypeID) VALUES 
('Horse', 2),   -- Лошади
('Camel', 2),   -- Верблюды
('Donkey', 2);  -- Ослы

-- Заполнение таблицы dogs
INSERT INTO dogs (DomesticAnimalID, Name, Command, BirthDate) VALUES 
(1, 'Buddy', 'Sit', '2023-05-15'),
(2, 'Max', 'Stay', '2020-01-20'),
(3, 'Bella', 'Come', '2021-06-10');

-- Заполнение таблицы cats
INSERT INTO cats (DomesticAnimalID, Name, Command, BirthDate) VALUES 
(1, 'Whiskers', 'Jump', '2023-07-22'),
(2, 'Mittens', 'Roll over', '2019-03-05'),
(3, 'Luna', 'Play dead', '2021-11-15');

-- Заполнение таблицы hamsters
INSERT INTO hamsters (DomesticAnimalID, Name, Command, BirthDate) VALUES 
(1, 'Nibbles', 'Spin', '2023-08-01'),
(2, 'Puffy', 'Run', '2019-12-12'),
(3, 'Squeaky', 'Stand', '2021-02-20');

-- Заполнение таблицы horses
INSERT INTO horses (PackAnimalID, Name, Command, BirthDate) VALUES 
(1, 'Spirit', 'Gallop', '2023-04-10'),
(2, 'Shadow', 'Trot', '2018-09-15'),
(3, 'Blaze', 'Canter', '2021-01-25');

-- Заполнение таблицы camels
INSERT INTO camels (PackAnimalID, Name, Command, BirthDate) VALUES 
(1, 'Coco', 'Kneel', '2023-03-18'),
(2, 'Ginger', 'Run', '2017-11-30'),
(3, 'Biscuit', 'Stand', '2020-05-05');

-- Заполнение таблицы donkeys
INSERT INTO donkeys (PackAnimalID, Name, Command, BirthDate) VALUES 
(1, 'Eeyore', 'Bray', '2023-02-14'),
(2, 'Jack', 'Walk', '2016-07-04'),
(3, 'Daisy', 'Run', '2021-09-09');
```  

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
#### Выполнение
```sql
-- Удаление верблюдов
DELETE FROM camels;
```  

```sql
-- Создание новой таблицы horsesdonkeys с объединенными данными
CREATE TABLE horsesdonkeys (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Command VARCHAR(255),
    BirthDate DATE,
    AnimalType VARCHAR(50)
);

INSERT INTO horsesdonkeys (Name, Command, BirthDate, AnimalType)
SELECT Name, Command, BirthDate, 'Horse' AS AnimalType FROM horses
UNION ALL
SELECT Name, Command, BirthDate, 'Donkey' AS AnimalType FROM donkeys;
```  

11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.
#### Выполнение
```sql
-- Создание новой таблицы younganimals
CREATE TABLE younganimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Command VARCHAR(255),
    BirthDate DATE,
    AgeInMonths INT  -- Поле для хранения возраста в месяцах
);
```  

```sql
-- Вставка данных о молодых животных
INSERT INTO younganimals (Name, Command, BirthDate, AgeInMonths)
SELECT Name, Command, BirthDate, 
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths
FROM (
    SELECT Name, Command, BirthDate FROM dogs
    UNION ALL
    SELECT Name, Command, BirthDate FROM cats
    UNION ALL
    SELECT Name, Command, BirthDate FROM hamsters
    UNION ALL
    SELECT Name, Command, BirthDate FROM horses
    UNION ALL
    SELECT Name, Command, BirthDate FROM donkeys
) AS all_animals
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) >= 1 
      AND TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) < 3;
```  
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
#### Выполнение
```sql
-- Создание результирующей таблицы allanimals
CREATE TABLE allanimals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Command VARCHAR(100),
    BirthDate DATE,
    AgeInMonths INT,
    SourceTable VARCHAR(20)
);
```  
```sql
-- Вставка данных из таблицы dogs
INSERT INTO allanimals (Name, Command, BirthDate, AgeInMonths, SourceTable)
SELECT Name, Command, BirthDate, 
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths, 
       'dogs' AS SourceTable
FROM dogs;

-- Вставка данных из таблицы cats
INSERT INTO allanimals (Name, Command, BirthDate, AgeInMonths, SourceTable)
SELECT Name, Command, BirthDate, 
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths, 
       'cats' AS SourceTable
FROM cats;

-- Вставка данных из таблицы hamsters
INSERT INTO allanimals (Name, Command, BirthDate, AgeInMonths, SourceTable)
SELECT Name, Command, BirthDate, 
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths, 
       'hamsters' AS SourceTable
FROM hamsters;

-- Вставка данных из таблицы horses
INSERT INTO allanimals (Name, Command, BirthDate, AgeInMonths, SourceTable)
SELECT Name, Command, BirthDate, 
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths, 
       'horses' AS SourceTable
FROM horses;

-- Вставка данных из таблицы donkeys
INSERT INTO allanimals (Name, Command, BirthDate, AgeInMonths, SourceTable)
SELECT Name, Command, BirthDate, 
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths, 
       'donkeys' AS SourceTable
FROM donkeys;
```  
