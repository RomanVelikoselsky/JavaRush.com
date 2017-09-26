/*
имеется таблица с 1 полем, заполненная числами по порядку: {1,2,4,7,8,11..}.
Написать SQL Запрос который делает выборку следующего вида (2 столбца): {{3,1},{5,2},...}, Т.е. в
первом поле идет число, с которого начинается пропуск, во втором количество пропущенных чисел;
 */
public class TestSQL {
    /*
SELECT numb, (numbers-numb) AS len
FROM
(SELECT numbers,
@num := @num + 1,
@num AS numb,
(if(numbers = @num, @temp := 0, @num := numbers)) AS n
FROM testtable, (SELECT @num := 0) AS num,(SELECT @temp := 0) AS temp) AS pretab
WHERE n > 0;

// testtable - таблица
// numbers - столбец со значениями
// numb - число начала пропуска
// len - число пропущенных чисел
     */
}
