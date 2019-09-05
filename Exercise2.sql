CREATE TABLE dataSetTable([Id] int, [HOME_PAGE] int, [PRODUCT_PAGE] int, [WARRANTY_PAGE] int);

INSERT INTO dataSetTable
([Id], [HOME_PAGE], [PRODUCT_PAGE], [WARRANTY_PAGE])
VALUES
(1, 1, 1, 1),
(2, 1, 0, 1),
(3, 1, 0, 1),
(4, 0, 0, 1),
(5, 1, 1, 0),
(6, 0, 1, 0),
(7, 0, 1, 1);

select columnname as Page, sum(rowvalue) as Counts
from dataSetTable as dt
         UNPIVOT (
         rowvalue for columnname in (HOME_PAGE, PRODUCT_PAGE, WARRANTY_PAGE)
         ) as unpv
GROUP BY columnname


/*   OUTPUT :

|          Page | Counts |
|---------------|--------|
|     HOME_PAGE |      4 |
|  PRODUCT_PAGE |      4 |
| WARRANTY_PAGE |      5 |

 */
