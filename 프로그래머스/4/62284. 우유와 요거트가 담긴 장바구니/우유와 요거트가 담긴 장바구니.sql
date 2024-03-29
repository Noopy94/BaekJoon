WITH TEMP1 AS (
    SELECT CART_ID
    FROM CART_PRODUCTS 
    WHERE NAME = 'Milk'
),
TEMP2 AS (
    SELECT CART_ID
    FROM CART_PRODUCTS 
    WHERE NAME = 'Yogurt'
)
SELECT 
    T1.CART_ID
FROM TEMP1 T1
INNER JOIN TEMP2 T2 ON T1.CART_ID = T2.CART_ID
ORDER BY CART_ID;