SELECT
    AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_OUTS AO
INNER JOIN ANIMAL_INS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
ORDER BY (AO.DATETIME-AI.DATETIME) DESC
LIMIT 2