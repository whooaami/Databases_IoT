-- 1. БД «Фірма прий. вторсировини». Вивести інформацію про прийом
-- грошей на пункті прийому No1 таблиці Income. Вихідні дані впоряд-
-- кувати за зростанням за стовпцем inc.
SELECT * FROM income ORDER BY inc;

-- 2. БД «Аеропорт». Вивести прізвища пасажирів (друге слово в стовпці
-- name), що не починаються на літеру 'J'.
SELECT SUBSTRING_INDEX(name,' ',-1) AS LastName FROM Passenger 
WHERE SUBSTRING_INDEX(name,' ',-1) NOT LIKE '%J%';

-- 3. БД «Кораблі». Для кораблів, що вціліли в битвах, вивести назви та
-- дати битв, у яких вони брали участь.
SELECT outcomes.ship, battles.name, battles.date, outcomes.result FROM outcomes 
INNER JOIN battles 
ON outcomes.battle = battles.name 
WHERE outcomes.result NOT LIKE 'sunk';

-- 4. БД «Комп. фірма». Знайти моделі та ціни ноутбуків, вартість яких є
-- вищою за вартість будь-якого ПК. Вивести: model, price.
SELECT model, price FROM laptop
WHERE price > ALL
(SELECT price FROM pc);

-- 5. БД «Комп. фірма». Знайдіть виробників, які б випускали одночасно
-- ПК та ноутбуки зі швидкістю 750 МГц та вище. Виведіть: maker.
SELECT pc.model, product.maker, product.type FROM pc
INNER JOIN product
ON pc.model = product.model
WHERE pc.speed >= 750
UNION ALL
SELECT laptop.model, product.maker, product.type FROM laptop
INNER JOIN product
ON laptop.model = product.model
WHERE laptop.speed >= 750;

-- 6. БД «Комп. фірма». Для таблиці Printer вивести всю інформацію з
-- коментарями в кожній комірці, наприклад, 'модель: 1276', 'ціна:
-- 400,00' і т.д.
SELECT CONCAT('Model: ', model) AS Model,
CONCAT('Gray scale: ', color) AS isGrayScale,
CONCAT('Type: ', type) AS Type,
CONCAT('Price: ', price) AS Price 
FROM printer;

-- 7. БД «Аеропорт». Визначіть кількість рейсів до міста 'Moscow' для
-- кожної дати таблиці Pass_in_trip. Вивести: date, число рейсів.
SELECT trip.trip_no, count(*), pass_in_trip.date FROM pass_in_trip
JOIN trip
ON trip.trip_no = pass_in_trip.trip_no
WHERE town_from = 'Moscow' GROUP BY date, trip_no;

-- 8. БД «Комп. фірма». Для таблиці Product отримати підсумковий набір
-- у вигляді таблиці зі стовпцями maker, pc, laptop та printer, у якій для
-- кожного виробника необхідно вказати кількість різної продукції, що
-- ним випускається, тобто продукції з різними (унікальними) номерами
-- моделей у таблицях, відповідно, PC, Laptop та Printer. (Підказка:
-- використовувати підзапити в якості обчислювальних стовпців)
SELECT 
	Product.maker,
	COUNT(pc_data.model) AS PC,
	COUNT(laptop_data.model) AS Laptop,
	COUNT(printer_data.model) AS Printer 
FROM Product
LEFT OUTER JOIN 
	(SELECT maker,PC.model 
	FROM PC 
	JOIN Product 
	ON PC.model=Product.model) AS pc_data
ON Product.model=pc_data.model
LEFT OUTER JOIN 
	(SELECT maker,Laptop.model 
	FROM Laptop 
	JOIN Product 
	ON Laptop.model=Product.model) AS laptop_data
ON Product.model=laptop_data.model
LEFT OUTER JOIN 
	(SELECT maker,Printer.model 
	FROM Printer 
	JOIN Product 
	ON Printer.model=Product.model) AS printer_data
ON Product.model=printer_data.model
GROUP BY maker 
ORDER BY 1;

-- 9. БД «Фірма прий. вторсировини». Визначіть лідера за сумою виплат
-- у змаганні між кожною парою пунктів з однаковими номерами із двох
-- різних таблиць – Outcome та Outcome_o – на кожний день, коли
-- здійснювався прийом вторинної сировини хоча б на одному з них.
-- Вивести: Номер пункту, дата, текст: – 'once a day', якщо сума виплат є
-- більшою у фірми зі звітністю один раз на день; – 'more than once a
-- day', якщо – у фірми зі звітністю декілька разів на день; – 'both', якщо
-- сума виплат є однаковою. (Підказка: для з’єднання таблиць викорис-
-- товувати повне зовнішнє з’єднання, а для перевірки умов оператор
-- CASE; для пунктів що не мають у певні дні видачі грошей – необхідно
-- обробляти NULL-значення за допомогою перевірки умови IS [NOT]
-- NULL)
SELECT *,
	CASE
		WHEN not_once > once THEN 'more than once a day'
		WHEN not_once < once THEN 'once a day'
	ELSE 'both'
	END AS status
FROM
(SELECT
	outcome.point AS point,
	outcome.date AS date,
	SUM(outcome.out) AS not_once,
	SUM(outcome_o.out) AS once
FROM outcome_o
LEFT OUTER JOIN outcome
ON outcome_o.date = outcome.date
GROUP BY 1,2) AS data1 
WHERE point IS NOT NULL;

-- 10. БД «Кораблі». Знайдіть назви всіх кораблів із БД, про які можна
-- однозначно сказати, що вони були спущені на воду до 1942 р. Вивес-
-- ти: назву кораблів. (Підказка: використовувати оператор UNION )
SELECT name FROM ships
WHERE launched < 1942
GROUP BY name
UNION
SELECT DISTINCT ship FROM outcomes
WHERE ship IN (SELECT name FROM ships);
