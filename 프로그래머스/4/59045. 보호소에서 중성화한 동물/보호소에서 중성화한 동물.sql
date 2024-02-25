SELECT 
    AO.ANIMAL_ID,
    AO.ANIMAL_TYPE,
    AO.NAME
FROM ANIMAL_OUTS AO
INNER JOIN ANIMAL_INS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE 
(LEFT (AI.SEX_UPON_INTAKE,6) = 'Intact' AND LEFT(AO.SEX_UPON_OUTCOME,6) = 'Spayed') 
OR (LEFT (AI.SEX_UPON_INTAKE,6) = 'Intact' AND LEFT(AO.SEX_UPON_OUTCOME,8) = 'Neutered') 
ORDER BY ANIMAL_ID

