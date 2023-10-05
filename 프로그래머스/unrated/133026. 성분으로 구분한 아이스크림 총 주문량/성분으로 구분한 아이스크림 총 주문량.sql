# 상반기 각 아이스크림 성분 타입
# 성분타입에 대한 아이스크림의 총 주문량


SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER)
FROM FIRST_HALF
JOIN ICECREAM_INFO ON FIRST_HALF.FLAVOR=ICECREAM_INFO.FLAVOR 
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER